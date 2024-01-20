import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Availibility {
    private Availibility[] bookingSlots;
    private boolean[] bays;  
}
