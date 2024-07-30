package com.example.flightstatus.controller;

import com.example.flightstatus.model.FlightStatusUpdateRequest;
import com.example.flightstatus.service.FlightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight-status")
public class FlightStatusController {

    @Autowired
    private FlightStatusService flightStatusService;

    @PostMapping("/delay")
    public ResponseEntity<String> reportDelay(@RequestBody FlightStatusUpdateRequest request) {
        flightStatusService.processDelay(request);
        return ResponseEntity.ok("Delay reported successfully");
    }

    @PostMapping("/gate-change")
    public ResponseEntity<String> reportGateChange(@RequestBody FlightStatusUpdateRequest request) {
        flightStatusService.processGateChange(request);
        return ResponseEntity.ok("Gate change reported successfully");
    }

    @PostMapping("/cancellation")
    public ResponseEntity<String> reportCancellation(@RequestBody FlightStatusUpdateRequest request) {
        flightStatusService.processCancellation(request);
        return ResponseEntity.ok("Cancellation reported successfully");
    }
}