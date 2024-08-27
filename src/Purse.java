import java.util.Map;

public class Purse {
    Map<Denomination, Integer> cash; //Represents the money in the purse
    public void add(Denomination MoneyType, int amount) {
        cash.put(MoneyType, amount);
    }

    public double remove(Denomination MoneyType, int num) {
        cash.remove(MoneyType, num);
        return (cash.get(MoneyType.amt()) * num);
    }

    public double getValue() {
        double resultValue = 0.0;
        String tempName;
        double temp;
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination tempDenom = entry.getKey();
            tempName = entry.toString();
            temp = entry.getValue();

            if (tempName == "Hundred Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Fifty Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Twenty Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            }
            else if (tempName == "Ten Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Five Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            }
            else if (tempName == "One Bill") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Fifty Cent") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Quarter") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Dime") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Nickel") {
                resultValue = resultValue + (temp * tempDenom.amt());
            } else if (tempName == "Penny") {
                resultValue = resultValue + (temp * tempDenom.amt());
            }
        }
        return resultValue;
    }

    public String toString() {
        String returnString = "";
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            returnString += entry.getKey().toString() + ": " + entry.getValue() + "\n";
        }
        return returnString;
    }

}
