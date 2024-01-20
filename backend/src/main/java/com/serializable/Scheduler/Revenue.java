public class Revenue{
    private int numOfCompact;
    private int numOfMedium;  
    private int numOfFull;
    private int numOfTruck1; 
    private int numOfTruck2;  

    public void incrementVehcle(String typeOfVehicle){
        switch (typeOfVehicle) {
            
            case COMPACT_CAR:
            numOfCompact++;
                break;

            case MEDIUM_CAR:
            numOfMedium++;
                break;

            case FULL_SIZE_CAR:
            numOfFull++;
                break;

            case TRUCK_1:
            numOfTruck1++;
                break;

            case TRUCK_2:
            numOfTruck2++;
                break;
        }
    }
}