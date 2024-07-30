package com.example.flightstatus.model;

public class NotificationEvent {

    private String flightId;
    private String passengerId;
    private String status;
    private String additionalInfo;

    public NotificationEvent(String flightId, String passengerId, String status, String additionalInfo) {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.status = status;
        this.additionalInfo = additionalInfo;
    }

    // Getters and setters
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
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