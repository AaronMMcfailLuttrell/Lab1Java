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
        String returnString = "";





        for (Map.Entry<Denomination, Integer> Hund : cash.entrySet()) {
            Denomination placeholder = Hund.getKey();
            if (placeholder.amt() == 100.00) {
                returnString += Hund.getValue() + " " + Hund.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Fift : cash.entrySet()) {
            Denomination placeholder = Fift.getKey();
            if (placeholder.amt() == 50.00) {
                returnString += Fift.getValue() + " " + Fift.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Twent : cash.entrySet()) {
            Denomination placeholder = Twent.getKey();
            if (placeholder.amt() == 20.00) {
                returnString += Twent.getValue() + " " + Twent.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Tenb : cash.entrySet()) {
            Denomination placeholder = Tenb.getKey();
            if (placeholder.amt() == 10.00) {
                returnString += Tenb.getValue() + " " + Tenb.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Fiveb : cash.entrySet()) {
            Denomination placeholder = Fiveb.getKey();
            if (placeholder.amt() == 5.00) {
                returnString += Fiveb.getValue() + " " + Fiveb.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Oneb : cash.entrySet()) {
            Denomination placeholder = Oneb.getKey();
            if (placeholder.amt() == 1.00) {
                returnString += Oneb.getValue() + " " + Oneb.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Quart : cash.entrySet()) {
            Denomination placeholder = Quart.getKey();
            if (placeholder.amt() == .25) {
                returnString += Quart.getValue() + " " + Quart.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Dim : cash.entrySet()) {
            Denomination placeholder = Dim.getKey();
            if (placeholder.amt() == .10) {
                returnString += Dim.getValue() + " " + Dim.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Nick : cash.entrySet()) {
            Denomination placeholder = Nick.getKey();
            if (placeholder.amt() == .05) {
                returnString += Nick.getValue() + " " + Nick.getKey().name() + "\n";
            }

        }

        for (Map.Entry<Denomination, Integer> Penn : cash.entrySet()) {
            Denomination placeholder = Penn.getKey();
            if (placeholder.amt() == .01) {
                returnString += Penn.getValue() + " " + Penn.getKey().name() + "\n";
            }

        }




        return returnString;
    }

}
