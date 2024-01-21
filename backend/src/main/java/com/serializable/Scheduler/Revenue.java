package com.serializable.Scheduler;
import lombok.Data;

@Data
public class Revenue {
    private int numOfCompact;
    private int numOfMedium;
    private int numOfFull;
    private int numOfTruck1;
    private int numOfTruck2;
    private int numOfCompactTA;
    private int numOfMediumTA;
    private int numOfFullTA;
    private int numOfTruck1TA;
    private int numOfTruck2TA;
    private int totalRevenueWinnings;
    private int totalRevenueLoss;

    private final int CHARGE_COMPACT = 150;
    private final int CHARGE_MEDIUM = 150;
    private final int CHARGE_FULL = 150;
    private final int CHARGE_TRUCK1 = 250;
    private final int CHARGE_TRUCK2 = 700;

    public void incrementRevenue(String typeOfVehicle) {
        switch (typeOfVehicle) {
            case "compact":
                numOfCompact++;
                totalRevenueWinnings += CHARGE_COMPACT;
                break;
            case "medium":
                numOfMedium++;
                totalRevenueWinnings += CHARGE_MEDIUM;
                break;
            case "full-size":
                numOfFull++;
                totalRevenueWinnings += CHARGE_FULL;
                break;
            case "class 1 truck":
                numOfTruck1++;
                totalRevenueWinnings += CHARGE_TRUCK1;
                break;
            case "class 2 truck":
                numOfTruck2++;
                totalRevenueWinnings += CHARGE_TRUCK2;
                break;
        }
    }

    public void incrementRevenueLoss(String typeOfVehicle) {
        switch (typeOfVehicle) {
            case "compact":
                numOfCompactTA++;
                totalRevenueLoss += CHARGE_COMPACT;
                break;
            case "medium":
                numOfMediumTA++;  
                totalRevenueLoss += CHARGE_MEDIUM;
                break;
            case "full-size":
                numOfFullTA++;
                totalRevenueLoss += CHARGE_FULL;
                break;
            case "class 1 truck":
                numOfTruck1TA++;
                totalRevenueLoss += CHARGE_TRUCK1;
                break;
            case "class 2 truck":
                numOfTruck2TA++;
                totalRevenueLoss += CHARGE_TRUCK2;
                break;
        }
    }

    public int getTotalRevenue() {
        return totalRevenueWinnings - totalRevenueLoss;
    }
}
