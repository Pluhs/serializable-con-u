package com.serializable.Scheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class Controller {
    
    @GetMapping("/{type}")
    String getVehicle(@PathVariable String type) {
        return type;
    }
    @DeleteMapping("/{}")
}
