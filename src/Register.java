import java.util.IdentityHashMap;
import java.util.Scanner;

public class Register {

    //Make use of the denomination
    private static final Denomination Hundred = new Denomination("Hundred Bill", 100.00, "bill", "Hundred.png");
    private static final Denomination Fifty = new Denomination("Fifty Bill", 50.00, "bill", "Fifty.png");
    private static final Denomination Twenty = new Denomination("Twenty Bill", 20.00, "bill", "Twenty.png");
    private static final Denomination Ten = new Denomination("Ten Bill", 10.00, "bill", "Ten.png");
    private static final Denomination Five = new Denomination("Five Bill", 5.00, "bill", "Five.png");
    private static final Denomination One = new Denomination("One Bill", 1.00, "bill", "One.png");
    private static final Denomination FiftyCent = new Denomination("Fifty Cent", .50, "coin", "FiftyCent.png");
    private static final Denomination Quarter = new Denomination("Quarter", .25, "coin", "Quarter.png");
    private static final Denomination Dime = new Denomination("Dime", .10, "coin", "Dime.png");
    private static final Denomination Nickle = new Denomination("Nickle", .05, "coin", "Nickle.png");
    private static final Denomination Penny = new Denomination("Penny", .01, "coin", "Penny.png");

    //Calculate from greatest to least to see how minimal amount to return.
    Purse makeChange(double amt) {
        int[] countCurrency = new int[11];

        for (int i = 0; i < 11; i++) {
            countCurrency[i] = 0;
        }

        /*
        * int[0] = $100 bill, int[1] = $50, int[2] = $20, int[3] = $10, int[4] = $5
        * int[5] = $1 bill, int[6] = $.50, int[7] = $.25, int[8] = $.10, int[9] = $.05
        * int[10] = $.01
        */

        while (amt > 0.0) {
            if (amt >= 100) {
                amt -= 100;
                countCurrency[0]++;
            } else if (amt >= 50) {
                amt -= 50;
                countCurrency[1]++;
            } else if (amt >= 20) {
                amt -= 20;
                countCurrency[2]++;
            } else if (amt >= 10) {
                amt -= 10;
                countCurrency[3]++;
            } else if (amt >= 5) {
                amt -= 5;
                countCurrency[4]++;
            } else if (amt >= 1) {
                amt -= 1;
                countCurrency[5]++;
            } else if (amt >= .5) {
                amt -= .5;
                countCurrency[6]++;
            } else if (amt >= .25) {
                amt -= .25;
                countCurrency[7]++;
            } else if (amt >= .1) {
                amt -= .1;
                countCurrency[8]++;
            } else if (amt >= .05) {
                amt -= .05;
                countCurrency[9]++;
            } else if (amt >= .01) {
                amt -= .01;
                countCurrency[10]++;
            }
        }


        Purse tempPurse = new Purse();
        if (countCurrency[0] != 0) {
            tempPurse.add(Hundred, countCurrency[0]);
        } else if (countCurrency[1] != 0) {
            tempPurse.add(Fifty, countCurrency[1]);
        } else if (countCurrency[2] != 0) {
            tempPurse.add(Twenty, countCurrency[2]);
        } else if (countCurrency[3] != 0) {
            tempPurse.add(Ten, countCurrency[3]);
        } else if (countCurrency[4] != 0) {
            tempPurse.add(Five, countCurrency[4]);
        } else if (countCurrency[5] != 0) {
            tempPurse.add(One, countCurrency[5]);
        } else if (countCurrency[6] != 0) {
            tempPurse.add(FiftyCent, countCurrency[6]);
        } else if (countCurrency[7] != 0) {
            tempPurse.add(Quarter, countCurrency[7]);
        } else if (countCurrency[8] != 0) {
            tempPurse.add(Dime, countCurrency[8]);
        } else if (countCurrency[9] != 0) {
            tempPurse.add(Nickle, countCurrency[9]);
        } else if (countCurrency[10] != 0) {
            tempPurse.add(Penny, countCurrency[10]);
        }

        return tempPurse;

    }

    public static void main(String[] args) {

        Register register = new Register();
        double userValue = 0.0;
        Purse tempPurse;
        String printString;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a value to insert to the purse: ");
        userValue = scan.nextDouble();

        tempPurse = register.makeChange(userValue);
        printString = tempPurse.toString();

        System.out.println(printString);

    }

}
