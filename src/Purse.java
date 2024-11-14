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
    @Override
    public String toString() {
        StringBuilderFacade facade = new StringBuilderFacade();
        return facade.createDisplayString(cash);
    }
}
