package com.serializable.Scheduler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Vehicle {
    private final LocalDateTime requestDate;
    private final LocalDateTime serviceDate;
    private final String vehicleType;

    public Vehicle(String vehicleType, LocalDateTime serviceDate, LocalDateTime requestDate) {
        this.vehicleType = vehicleType;
        this.serviceDate = serviceDate;
        this.requestDate = requestDate;
    }

}