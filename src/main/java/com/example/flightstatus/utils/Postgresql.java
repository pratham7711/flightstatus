package com.example.flightstatus.utils;

import java.sql.*;
import java.util.Properties;
import java.util.function.Function;

public class Postgresql {

    private final String username;
    private final String password;
    private final String url;
    private final int fetchSize;
    private boolean isFinished = false;
    private Connection conn;
    private boolean isExternal = false;

    public Postgresql(Properties props) {
        this.username = props.getProperty("username");
        this.password = props.getProperty("password");
        this.fetchSize = Integer.parseInt(props.getProperty("fetchSize", "25000"));
        this.url = props.getProperty("url", "jdbc:postgresql://localhost:5432/flightstatus");
    }

    public Postgresql(Connection conn, Properties props) {
        this(props);
        isExternal = true;
        this.conn = conn;
    }

    private Connection createConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public void updateFlightTime(String flightId, Time newTime) throws SQLException {
        String updateQuery = "UPDATE flights SET time = ? WHERE id = ?";
        try {
            if (conn == null || conn.isClosed()) {
                createConnection();
            }
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setTime(1, newTime);
                pstmt.setString(2, flightId);
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Updating flight time failed, no rows affected.");
                }
            }
        } finally {
            if (conn != null && !isExternal) {
                close();
            }
        }
    }
    public <T> void read(String query, Function<ResultSet, T> mapper, Function<T, Void> onEachRecord) throws SQLException {
        isFinished = false;
        try {
            if (conn == null || conn.isClosed()) {
                createConnection();
            }
            try (var stmt = conn.createStatement()) {
                stmt.setFetchSize(fetchSize);
                var rs = stmt.executeQuery(query);
                while (rs.next()) {
                    if (onEachRecord == null)
                        mapper.apply(rs);
                    else
                        onEachRecord.apply(mapper.apply(rs));
                }
            }
        } finally {
            isFinished = true;
            if (conn != null && !isExternal) {
                close();
            }
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.setProperty("username", "postgres");
//        props.setProperty("password", "pratham7711");
//        props.setProperty("url", "jdbc:postgresql://localhost:5432/flightstatus");
//
//        Postgresql db = new Postgresql(props);
//
//        try {
//            String query = "SELECT * FROM flights";
//            db.read(query, rs -> {
//                try {
//                    System.out.println("Flight ID: " + rs.getString("id"));
//                    System.out.println("Flight Date: " + rs.getDate("date"));
//                    System.out.println("Flight Time: " + rs.getTime("time"));
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }, null);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            db.close();
//        }
    }
}