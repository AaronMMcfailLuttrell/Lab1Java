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

        int centCount = (int)((amt * 100) % 100);

        /*
        * int[0] = $100 bill, int[1] = $50, int[2] = $20, int[3] = $10, int[4] = $5
        * int[5] = $1 bill, int[6] = $.50, int[7] = $.25, int[8] = $.10, int[9] = $.05
        * int[10] = $.01
        */

        int amtInt = (int) amt;

        while (amtInt >= 100) {
            amtInt -= 100;
            countCurrency[0]++;
        }
        while (amtInt >= 50) {
            amtInt -= 50;
            countCurrency[1]++;
        }
        while (amtInt >= 20) {
            amtInt -= 20;
            countCurrency[2]++;
        }
        while (amtInt >= 10) {
            amtInt -= 10;
            countCurrency[3]++;
        }
        while (amtInt >= 5) {
            amtInt -= 5;
            countCurrency[4]++;
        }
        while (amtInt >= 1) {
            amtInt -= 1;
            countCurrency[5]++;
        }
        while (centCount >= 50) {
            centCount -= 50;
            countCurrency[6]++;
        }
        while (centCount >= 25) {
            centCount -= 25;
            countCurrency[7]++;
        }
        while (centCount >= 10) {
            centCount -= 10;
            countCurrency[8]++;
        }
        while (centCount >= 5) {
            centCount -= 5;
            countCurrency[9]++;
        }
        while (centCount >= 1) {
            centCount -= 1;
            countCurrency[10]++;
        }


        Purse tempPurse = new Purse();

        if (countCurrency[0] != 0) {
            tempPurse.add(Hundred, countCurrency[0]);
        }
        if (countCurrency[1] != 0) {
            tempPurse.add(Fifty, countCurrency[1]);
        }
        if (countCurrency[2] != 0) {
            tempPurse.add(Twenty, countCurrency[2]);
        }
        if (countCurrency[3] != 0) {
            tempPurse.add(Ten, countCurrency[3]);
        }
        if (countCurrency[4] != 0) {
            tempPurse.add(Five, countCurrency[4]);
        }
        if (countCurrency[5] != 0) {
            tempPurse.add(One, countCurrency[5]);
        }
        if (countCurrency[6] != 0) {
            tempPurse.add(FiftyCent, countCurrency[6]);
        }
        if (countCurrency[7] != 0) {
            tempPurse.add(Quarter, countCurrency[7]);
        }
        if (countCurrency[8] != 0) {
            tempPurse.add(Dime, countCurrency[8]);
        }
        if (countCurrency[9] != 0) {
            tempPurse.add(Nickle, countCurrency[9]);
        }
        if (countCurrency[10] != 0) {
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
        printString = tempPurse.toTheString();

        System.out.println(printString);

        System.out.println("The Purse value is: " + tempPurse.getValue());

    }

}
