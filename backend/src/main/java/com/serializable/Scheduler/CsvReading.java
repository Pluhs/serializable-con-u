package com.serializable.Scheduler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class CsvReading {
    private ArrayList<Vehicle> requests = new ArrayList<>();
    // private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    private ResourceLoader resourceLoader;
            
    @EventListener(ApplicationReadyEvent.class)
    public void readCsv() {

        try {
            Scanner scanner = new Scanner(resourceLoader.getResource("classpath:datafile.csv").getFile());
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] requestAttributes = line.split(",");
                LocalDateTime requestDate = parseDate(requestAttributes[0]);
                LocalDateTime serviceDate = parseDate(requestAttributes[1]);
                String vehicleType = requestAttributes[2];
                Vehicle vehicle = new Vehicle(vehicleType, serviceDate, requestDate); 
                requests.add(vehicle);
            }
        }
        catch (Exception e) {
        }

        // Sort the list based on request date
        Collections.sort(requests, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getRequestDate().compareTo(v2.getRequestDate());
            }
        });
    }

    public ArrayList<Vehicle> getRequests() {
        return requests;
    }

    // Utility method to parse date strings
    private LocalDateTime parseDate(String dateString) {
        try {
            return LocalDateTime.parse(dateString, dateFormatter);
        } catch (Exception e) {
            return null;
        }
    }
}
