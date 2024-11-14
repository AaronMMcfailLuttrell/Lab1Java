import java.util.HashMap;
import java.util.Map;

public class StringBuilderFacade {

    public String createDisplayString(Map<Denomination, Integer> cash) {
        StringBuilder returnString = new StringBuilder(); // Using StringBuilder for efficiency

        // Array for sorting in descending order
        double[] descendingValues = {100.00, 50.00, 20.00, 10.00, 5.00, 1.00, 0.25, 0.10, 0.05, 0.01};

        // Outer loop goes through descendingValues array
        for (double value : descendingValues) {
            // Inner loop searches for that value in the map
            for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
                Denomination placeholder = entry.getKey();
                if (placeholder.amt() == value) {
                    // Append the value to returnString
                    returnString.append(entry.getValue()).append(" ").append(placeholder.name()).append("\n");
                }
            }
        }

        return returnString.toString();
    }
}
