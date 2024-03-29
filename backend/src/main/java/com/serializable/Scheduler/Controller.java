package com.serializable.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CsvReading csvReading;
    private Scheduler scheduler;

    @GetMapping("/vehicles/{type}")
    public String getVehicle(@PathVariable String type) {
        return type;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return csvReading.getRequests();
    }

    @GetMapping("/revenue")
    public Revenue getRevenue() {
        return scheduler.getRevenue();
    }

    @GetMapping("/processRequests")
    public void processRequests() {
        scheduler.processRequests();
    }
}

