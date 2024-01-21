package com.serializable.Scheduler;
import lombok.Data;

@Data
public class Revenue {
    private int[] numOfEach = new int[5];
    private int[] numOfEachTA = new int[5];
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
                numOfEach[0]++;
                totalRevenueWinnings += CHARGE_COMPACT;
                break;
            case "medium":
                numOfEach[1]++;
                totalRevenueWinnings += CHARGE_MEDIUM;
                break;
            case "full-size":
                numOfEach[2]++;
                totalRevenueWinnings += CHARGE_FULL;
                break;
            case "class 1 truck":
                numOfEach[3]++;
                totalRevenueWinnings += CHARGE_TRUCK1;
                break;
            case "class 2 truck":
                numOfEach[4]++;
                totalRevenueWinnings += CHARGE_TRUCK2;
                break;
        }
    }

    public void incrementRevenueLoss(String typeOfVehicle) {
        switch (typeOfVehicle) {
            case "compact":
                numOfEachTA[0]++;
                totalRevenueLoss += CHARGE_COMPACT;
                break;
            case "medium":
                numOfEachTA[1]++;  
                totalRevenueLoss += CHARGE_MEDIUM;
                break;
            case "full-size":
                numOfEachTA[2]++;
                totalRevenueLoss += CHARGE_FULL;
                break;
            case "class 1 truck":
                numOfEachTA[3]++;
                totalRevenueLoss += CHARGE_TRUCK1;
                break;
            case "class 2 truck":
                numOfEachTA[4]++;
                totalRevenueLoss += CHARGE_TRUCK2;
                break;
        }
    }

    public int getTotalRevenue() {
        return totalRevenueWinnings - totalRevenueLoss;
    }
}
