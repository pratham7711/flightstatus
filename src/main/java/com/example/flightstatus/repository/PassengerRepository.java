package com.example.flightstatus.repository;

import com.example.flightstatus.model.PassengerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<PassengerModel, String> {
    List<PassengerModel> findByFlightId(String flightId);
}