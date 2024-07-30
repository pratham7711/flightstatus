package com.example.flightstatus.repository;

import com.example.flightstatus.model.FlightStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightStatusRepository extends JpaRepository<FlightStatusModel, String> {
}