import java.util.HashMap;
import java.util.Map;

public class Purse {
    Map<Denomination, Integer> cash; //Represents the money in the purse

    public Purse() {
        this.cash = new HashMap<>();
    }
    public void add(Denomination MoneyType, int amount) {
        cash.put(MoneyType, amount);
    }

    public double remove(Denomination MoneyType, int num) {
        cash.remove(MoneyType, num);
        return (cash.get(MoneyType.amt()) * num);
    }

    public double getValue() {

        double resultValue = 0.0;


        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {

            Denomination placeholder = entry.getKey();
            resultValue += (placeholder.amt() * entry.getValue());

        }
        return resultValue;
    }

    public String toTheString() {
        String returnString = "";
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            returnString += entry.getKey().toString() + ": " + entry.getValue() + "\n";
        }
        return returnString;
    }

}
