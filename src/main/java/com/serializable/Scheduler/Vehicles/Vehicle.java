import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private final String displayName;
    private final int serviceTime;
    private final int serviceCharge;
    private int numberServiced;
    private int numberDeclined;
    

    Vehicle(String displayName, int serviceTime, int serviceCharge) {
        this.displayName = displayName;
        this.serviceTime = serviceTime;
        this.serviceCharge = serviceCharge;
    }
}
