package com.serializable.Scheduler.Vehicles;

import lombok.Data;
import java.util.Date;

@Data
public class Vehicle {
    private final Date requestDate;
    private final Date serviceDate;
    private final String vehicleType;

    public Vehicle(String vehicleType, Date serviceDate, Date requestDate) {
        this.vehicleType = vehicleType;
        this.serviceDate = serviceDate;
        this.requestDate = requestDate;
    }

}