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
        Map<Denomination, Integer> tempDisplayMap = new HashMap();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {

        }
        String returnString = "";
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination placeholder = entry.getKey();
            returnString += entry.getValue() + " " + placeholder.name() + "\n";
        }
        return returnString;
    }

}
