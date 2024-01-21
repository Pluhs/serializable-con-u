package com.serializable.Scheduler.Vehicles;

import lombok.Data;

@Data
public class Vehicle {
    private final String requestTime;
    private final String serviceTime;
    private final String type;
    

    public Vehicle(String type, String serviceTime, String requestTime) {
        this.type = type;
        this.serviceTime = serviceTime;
        this.requestTime = requestTime;
    }
}