package com.example.flightstatus.service;

import com.example.flightstatus.model.*;
import com.example.flightstatus.repository.FlightStatusRepository;
import com.example.flightstatus.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightStatusService {

    @Autowired
    private KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    @Autowired
    private FlightStatusRepository flightStatusRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public void processDelay(FlightStatusUpdateRequest request) {
        updateStatus(request.getFlightId(), "DELAYED", request.getAdditionalInfo());
    }

    public void processGateChange(FlightStatusUpdateRequest request) {
        updateStatus(request.getFlightId(), "GATE_CHANGED", request.getAdditionalInfo());
    }

    public void processCancellation(FlightStatusUpdateRequest request) {
        updateStatus(request.getFlightId(), "CANCELLED", request.getAdditionalInfo());
    }

    private void updateStatus(String flightId, String newStatus, String additionalInfo) {
//        FlightStatusModel entity = flightStatusRepository.findById(flightId).orElse(new FlightStatusModel());
//        entity.setFlightId(flightId);
//        entity.setStatus(newStatus);
//        entity.setAdditionalInfo(additionalInfo);
//        flightStatusRepository.save(entity);

        
    }
}