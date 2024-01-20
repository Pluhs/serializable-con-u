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

    private checkBayHelper(int numBay){
        filled = false;
        if (bays[numBay] == true){
            for (int i = 5; i < 10; i++){
                if (bays[i] == true){
                    continue;
                }
                
                bays[i] = true;
                filled = true;
                break;
            }
        }
    }

    public boolean checkBay(Vehicle vehicle){
        switch(vehicle.displayName){
            case COMPACT_CAR[0]:
                checkBayHelper(0);
                break;
            case MEDIUM_CAR[1]:
                checkBayHelper(1);
                break;
            case FULL_SIZE_CAR[2]:
                checkBayHelper(2);
                break;
            case TRUCK_1[3]:
                checkBayHelper(3);
                break;
            case TRUCK_2[4]:
                checkBayHelper(4);
                break;
        }

    }
}
