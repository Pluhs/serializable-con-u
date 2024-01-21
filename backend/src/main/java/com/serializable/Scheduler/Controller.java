package com.serializable.Scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    CsvReading csvReading;

    @GetMapping("/{type}")
    String getVehicle(@PathVariable String type) {
        return type;
    }

    @GetMapping("/requests")
    String getRequests() {
        return csvReading.getRequests().toString();
    }
}
