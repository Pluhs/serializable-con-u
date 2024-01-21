package com.serializable.Scheduler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CsvReading {
    private ArrayList<Vehicle> requests = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    static String temp = "2022-09-10 07:28,2022-11-27 07:16,compact\r\n" +
                         "2022-09-09 18:30,2022-10-15 18:07,class 2 truck\r\n" +
                         "2022-09-18 15:20,2022-11-01 13:16,full-size\r\n" +
                         "2022-10-20 18:30,2022-11-23 09:21,full-size";
            
    @EventListener(ApplicationReadyEvent.class)
    public void readCsv() {
        String[] lines = temp.split("\r\n");
        for (String line : lines) {
            String[] requestAttributes = line.split(",");
            Date requestDate = parseDate(requestAttributes[0]);
            Date serviceDate = parseDate(requestAttributes[1]);
            String vehicleType = requestAttributes[2];
            Vehicle vehicle = new Vehicle(vehicleType, serviceDate, requestDate); 
            requests.add(vehicle);
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
    private Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            // Handle exception or log error
            return null;
        }
    }
}
