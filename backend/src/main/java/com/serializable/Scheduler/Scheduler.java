package com.serializable.Scheduler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


public class Scheduler {

    @Autowired
    private CsvReading csvReading;

    private Map<String, Vehicle[][][]> schedules;
    private boolean[] sharedBays;
    private Revenue revenue;

    public Scheduler(CsvReading csvReading) {
        this.schedules = new HashMap<>();
        this.sharedBays = new boolean[5];
        this.revenue = new Revenue();

        for (String vehicleType : new String[]{"compact", "medium", "full-size", "class 1 truck", "class 2 truck"}) {
            schedules.put(vehicleType, new Vehicle[61][24][1]);
        }
    }

    private boolean checkSharedBays(Vehicle vehicle) {
        for(int i = 0; i < 5; i++){
            if (!sharedBays[i]) {
                sharedBays[i] = true;
                break;
            }
        }
        return true;
    }

    private void resetSharedBays() {
        sharedBays = new boolean[5];
    }
    private void resetSchedules() {
        schedules = new HashMap<>();
        for (String vehicleType : new String[]{"compact", "medium", "full-size", "class 1 truck", "class 2 truck"}) {
            schedules.put(vehicleType, new Vehicle[61][24][1]);
        }
    }

    public void processRequests() {
        resetSharedBays();
        resetSchedules();
        List<Vehicle> vehicles = csvReading.getRequests();

        for (Vehicle vehicle : vehicles) {
            LocalDateTime requestDate = vehicle.getRequestDate();

            int month = requestDate.getMonthValue();
            int day = requestDate.getDayOfMonth();
            int hour = requestDate.getHour();
            int minute = requestDate.getMinute();

            if (month == 11){
                day += 31;
            }

            int timeSlot = (hour - 6) * 2 + (minute == 30 ? 1 : 0);

            String vehicleType = vehicle.getVehicleType();

            Vehicle[][][] schedule = schedules.get(vehicleType);

            int serviceTime = getServiceTime(vehicleType);

            if (isSlotAvailable(schedule, day - 1, timeSlot, serviceTime) || checkSharedBays(vehicle)) {
                occupySlot(schedule, day - 1, timeSlot, vehicle, serviceTime);
                revenue.incrementRevenue(vehicleType);
            } else {
                revenue.incrementRevenueLoss(vehicleType);
            }
        }
    }

    private boolean isSlotAvailable(Vehicle[][][] schedule, int day, int timeSlot, int serviceTime) {
        for (int i = timeSlot; i < timeSlot + serviceTime; i++) {
            if (schedule[day][i][0] != null) {
                return false;
            }
        }
        return true;
    }

    private void occupySlot(Vehicle[][][] schedule, int day, int timeSlot, Vehicle vehicle, int serviceTime) {
        for (int i = timeSlot; i < timeSlot + serviceTime; i++) {
            schedule[day][i][0] = vehicle;
        }
    }

    private int getServiceTime(String vehicleType) {
        switch (vehicleType) {
            case "compact":
            case "medium":
            case "full-size":
                return 1;
            case "class 1 truck":
                return 2;
            case "class 2 truck":
                return 4;
            default:
                return 0;
        }
    }
}
