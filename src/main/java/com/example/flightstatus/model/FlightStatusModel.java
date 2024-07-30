package com.example.flightstatus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Time;
import java.sql.Date;

@Entity
public class FlightStatusModel {

    @Id
    private String flightId;

    private Time time;

    private Date date;

    private String gate;

    private String status; // Status of the flight, e.g., DELAYED, GATE_CHANGED, CANCELLED

    private String additionalInfo; // Optional, for any extra data like new gate number

    // Getters and setters
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}