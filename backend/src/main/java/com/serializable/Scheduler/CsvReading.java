package com.serializable.Scheduler;

import java.util.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.serializable.Scheduler.Vehicles.*;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;

@Service
public class CsvReading {

    private ArrayList<Vehicle> requests = new ArrayList<>();

    static String temp = "2022-09-10 07:28,2022-11-27 07:16,compact\r\n" + //
            "2022-09-09 18:30,2022-10-15 18:07,class 2 truck\r\n" + //
            "2022-09-18 15:20,2022-11-01 13:16,full-size\r\n" + //
            "2022-10-20 18:30,2022-11-23 09:21,full-size";
            
    @EventListener(ApplicationReadyEvent.class)
    public void readCsv(){
        String[] lines = temp.split("\r\n");
        for (int i = 0; i< lines.length; i++) {
            String line = lines[i];
            String[] requestAttributes = line.split(",");

            String requestDate = requestAttributes[0];
            String serviceDate = requestAttributes[1];
            String vehicleType = requestAttributes[2];

            Vehicle vehicle = new Vehicle(vehicleType, serviceDate, requestDate); 
            requests.add(vehicle);
        }
    }

    public ArrayList<Vehicle> getRequests() {
        return requests;
    }
}