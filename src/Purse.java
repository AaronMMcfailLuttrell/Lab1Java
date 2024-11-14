import java.util.HashMap;
import java.util.Map;

public class Purse {
    Map<Denomination, Integer> cash; //Represents the money in the purse
    ConcreteContextOper oper = new ConcreteContextOper();
    public Purse() {
        //Constructor that creates the HashMap, which stores the data about how much of each currency the user has
        this.cash = new HashMap<>();
    }
    public void add(Denomination MoneyType, int amount) {
        //adds a specific type of currency and the amount they have of it to the map.
        cash.put(MoneyType, amount);
    }

    public double remove(Denomination MoneyType, int num) {
        //Removes a type of currency and the amount the user removed
        cash.remove(MoneyType, num);

        /*
        IMPLEMENTS CONCRETE PATTERN
         */
        oper.setOperations(new OperationMult());
        return oper.executeOperations((double)cash.get(MoneyType.amt()), (double) num);
    }

    public double getValue() {
        double resultValue = 0.0;
        oper.setOperations(new OperationMult());
        //Loop iterates through the cash map and multiplies the amt it has to the amount of that currency they have, adds to resultValue
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination placeholder = entry.getKey();
            resultValue += oper.executeOperations((double) placeholder.amt(), (double) entry.getValue());
        }

        return resultValue;
    }

    public String toString() {
        Map<Denomination, Integer> tempDisplayMap = new HashMap();
        String returnString = ""; //The string that will be returned; the loops build onto it

        //Array for storing information for future sorting
        double[] DescendingValues = {100.00, 50.00,20.00, 10.00, 5.00, 1.00, .25, .10, .05, .01};

        //for sorting purposes, the outer loop goes through DescendingValues array and the inner loop searches for that value in the map and then displays the value
        for (int i = 0; i < DescendingValues.length; i++) {
            for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
                //Create a variable for easier access to the map entry key
                Denomination placeholder = entry.getKey();
                if (placeholder.amt() == DescendingValues[i]) {
                    //If it finds the correct value, add the following to the returnString
                    returnString += entry.getValue() + " " + placeholder.name() + "\n";
                }
            }
        }

        return returnString;
    }
}
