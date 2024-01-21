package com.serializable.Scheduler;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.serializable.Scheduler.Vehicles.*;

import java.util.ArrayList;

@Service
public class CsvReading {

    private ArrayList<Vehicle> requests = new ArrayList<>();
    @Autowired
    private ResourceLoader resourceLoader;
            
    @EventListener(ApplicationReadyEvent.class)
    public void readCsv(){
        try {
            Scanner scanner = new Scanner(resourceLoader.getResource("classpath:datafile.csv").getFile());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] requestAttributes = line.split(",");

                String requestDate = requestAttributes[0];
                String serviceDate = requestAttributes[1];
                String vehicleType = requestAttributes[2];

                Vehicle vehicle = new Vehicle(vehicleType, serviceDate, requestDate); 
                requests.add(vehicle);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Vehicle> getRequests() {
        return requests;
    }
}