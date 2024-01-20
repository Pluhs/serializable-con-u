package com.serializable.Scheduler.Vehicles;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private final Date requestTime;
    private final Date serviceTime;
    private final String type;

    public Vehicle(String type, Date serviceTime, Date requestTime) {
        this.type = type;
        this.serviceTime = serviceTime;
        this.requestTime = requestTime;
    }
}
