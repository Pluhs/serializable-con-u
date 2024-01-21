package com.serializable.Scheduler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {

    private CsvReading csvReading;
    private Map<String, Vehicle[][][]> schedules;
    private boolean[] sharedBays;
    private int[] servedCustomers;
    private int[] declinedCustomers;
    private Revenue revenue;

    public Scheduler(CsvReading csvReading) {
        this.csvReading = csvReading;
        this.schedules = new HashMap<>();
        this.sharedBays = new boolean[5];
        this.servedCustomers = new int[5];
        this.declinedCustomers = new int[5];
        this.revenue = new Revenue();

        for (String vehicleType : new String[]{"compact", "medium", "full-size", "class 1 truck", "class 2 truck"}) {
            schedules.put(vehicleType, new Vehicle[61][24][1]);
        }
    }

    private boolean checkBay(Vehicle vehicle) {
        String vehicleType = vehicle.getVehicleType();
        int bayIndex = getBayIndex(vehicleType);

        if (!sharedBays[bayIndex]) {
            sharedBays[bayIndex] = true;
            return true;
        }

        return false;
    }

    private int getBayIndex(String vehicleType) {
        switch (vehicleType) {
            case "compact":
                return 0;
            case "medium":
                return 1;
            case "full-size":
                return 2;
            case "class 1 truck":
                return 3;
            case "class 2 truck":
                return 4;
            default:
                return -1;
        }
    }

    public void processRequests() {
        List<Vehicle> vehicles = csvReading.getRequests();

        for (Vehicle vehicle : vehicles) {
            LocalDateTime serviceDate = vehicle.getServiceDate();
            LocalDateTime requestDate = vehicle.getRequestDate();

            int date = serviceDate.getDayOfMonth();
            int hour = requestDate.getHour();

            if (date < 1 || date > 61 || hour < 7 || hour >= 19) {
                continue;
            }

            String vehicleType = vehicle.getVehicleType();
            int bayIndex = getBayIndex(vehicleType);

            Vehicle[][][] schedule = schedules.get(vehicleType);

            int serviceTime = getServiceTime(vehicleType);

            if (isSlotAvailable(schedule, date - 1, hour, serviceTime) && checkBay(vehicle)) {
                occupySlot(schedule, date - 1, hour, vehicle, serviceTime);
                revenue.incrementRevenue(vehicleType);
                servedCustomers[bayIndex]++;
            } else {
                declinedCustomers[bayIndex]++;
                revenue.incrementRevenueLoss(vehicleType);
            }
        }
    }

    private boolean isSlotAvailable(Vehicle[][][] schedule, int dateIndex, int hourIndex, int serviceTime) {
        for (int i = hourIndex; i < hourIndex + serviceTime; i++) {
            if (schedule[dateIndex][i][0] != null) {
                return false;
            }
        }
        return true;
    }

    private void occupySlot(Vehicle[][][] schedule, int dateIndex, int hourIndex, Vehicle vehicle, int serviceTime) {
        for (int i = hourIndex; i < hourIndex + serviceTime; i++) {
            schedule[dateIndex][i][0] = vehicle;
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
