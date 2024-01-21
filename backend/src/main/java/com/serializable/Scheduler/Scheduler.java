import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scheduler {
    private Availibility[] bookingSlots;
    private boolean[] bays;
    private boolean filled;

    private void checkBayHelper(int numBay) {
        filled = false;
        if (bays[numBay] == true) {
            for (int i = 5; i < 10; i++) {
                if (bays[i] == true) {
                    continue;
                }

                bays[i] = true;
                filled = true;
                break;
            }
        }
    }

    public boolean checkBay(Vehicle vehicle) {
        switch (vehicle.getType) {
            case "compact":
                checkBayHelper(0);
                break;
            case "medium":
                checkBayHelper(1);
                break;
            case "full-size":
                checkBayHelper(2);
                break;
            case "class 1 truck":
                checkBayHelper(3);
                break;
            case "class 2 truck":
                checkBayHelper(4);
                break;
        }

    }
    private Vehicle[][][] bookingSlots = new Vehicle[2][31][24][10];
    private boolean[] bays;

    @Autowrired 
    private CsvReading csvReading;
    public sort(){
        Vehicle[] vehicles = csvReading.getRequests();
        for (int i = 0; i < vehicles.size; i++){
            if (checkBay(vehicles[i]) == false){
                
            }
            
        }
    }
}

