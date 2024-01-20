package com.serializable.Scheduler;

import java.text.DateFormat;
import java.util.Date;
import com.serializable.Scheduler.Vehicles.*;

public class CsvReading {

    static String temp = "2022-09-10 07:28,2022-11-27 07:16,compact\r\n" + //
            "2022-09-09 18:30,2022-10-15 18:07,class 2 truck\r\n" + //
            "2022-09-18 15:20,2022-11-01 13:16,full-size\r\n" + //
            "2022-10-20 18:30,2022-11-23 09:21,full-size";
            
    public static void readCSV(){
        String[] lines = temp.split("\r\n");
        for (int i = 0; i< lines.length; i++) {
            String line = lines[i];
            String[] requestAttributes = line.split(",");

            Date requestDate = new Date(requestAttributes[0]);
            Date serviceDate = new Date(requestAttributes[1]);
            String vehicleType = requestAttributes[2];

            Vehicle vehicle = new Vehicle(vehicleType, serviceDate, requestDate); 
        }
    }
}