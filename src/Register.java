import java.util.IdentityHashMap;
import java.util.Scanner;

public class Register {

    //Initialize the denominations to their associated string and value
    public static final Denomination Hundred = new Denomination("Hundred-Dollar Note", 100.00, "bill", "src\\HundredNote.jpg");
    public static final Denomination Fifty = new Denomination("Fifty-Dollar Note", 50.00, "bill", "src\\FiftyNote.jpg");
    public static final Denomination Twenty = new Denomination("Twenty-Dollar Note", 20.00, "bill", "src\\TwentyNote.jpg");
    public static final Denomination Ten = new Denomination("Ten-Dollar Note", 10.00, "bill", "src\\TenNote.jpg");
    public static final Denomination Five = new Denomination("Five-Dollar Note", 5.00, "bill", "src\\FiveNote.jpg");
    public static final Denomination One = new Denomination("One-Dollar Note", 1.00, "bill", "src\\OneNote.jpg");
    public static final Denomination Quarter = new Denomination("Quarter", .25, "coin", "src\\Quarter.jpeg");
    public static final Denomination Dime = new Denomination("Dime", .10, "coin", "src\\Dime.png");
    public static final Denomination Nickle = new Denomination("Nickle", .05, "coin", "src\\Nickel.jpg");
    public static final Denomination Penny = new Denomination("Penny", .01, "coin", "src\\Penny.png");

    //Calculate what amount of change to give the user (From highest value dollar to least value coin)
    Purse makeChange(double amt) {
        //Store the amount of each type of bill
        int[] countCurrency = new int[10];

        //Loop initializes all values of countCurrency to 0 so that it can start counting
        for (int i = 0; i < 10; i++) {
            countCurrency[i] = 0;
        }
        //Test to see if there is something like .005 which rounds to .01
        double roundingCentCount = (amt * 100) % 100;

        //Captures the .005 if the user inserts something like 12.735
        int anyRoundingSolving = (int)((roundingCentCount * 10) % 10);

        //Finally manipulates the value to turn the decimal value of the dollar input into an integer (for easier calculation purposes)
        int centCount = (int)((amt * 100) % 100);

        //According to expected output, having .005 cent should yield 1 penny, so this will add if it registers a .005. Tests for 5, as the integer is testing that
        if (anyRoundingSolving >= 5) {
            centCount += 1;
        }

        /*
        * int[0] = $100 bill, int[1] = $50, int[2] = $20, int[3] = $10, int[4] = $5
        * int[5] = $1 bill, int[6] = $.50, int[7] = $.25, int[8] = $.10, int[9] = $.05
        * int[10] = $.01
        */

        int amtInt = (int) amt; //Parses the whole number value of the user input, ex: user inputs 98.10, parses to 98

        //Does the subtraction for the whole value DOLLAR amounts and adds to each integer array
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

        //Does similar calculations to the above dollars, but for the CENT integer
        while (centCount >= 25) {
            centCount -= 25;
            countCurrency[6]++;
        }
        while (centCount >= 10) {
            centCount -= 10;
            countCurrency[7]++;
        }
        while (centCount >= 5) {
            centCount -= 5;
            countCurrency[8]++;
        }
        while (centCount >= 1) {
            centCount -= 1;
            countCurrency[9]++;
        }


        //Initialize a new Purse class to tempPurse to be able to add values
        Purse tempPurse = new Purse();

        /*
        Adds the specific denomination dollars and the amount there are into the purse, only adds to the purse if the amount is != 0
        */
        //For Iteration purposes
        Denomination[] currencyType = {Hundred, Fifty, Twenty, Ten, Five, One, Quarter, Dime, Nickle, Penny};

        for (int i = 0; i < 10; i++) {
            if (countCurrency[i] != 0) {
                tempPurse.add(currencyType[i], countCurrency[i]);
            }
        }

        //Returns a purse
        return tempPurse;

    }

    public static void main(String[] args) {
        //Initialize a register to start the program
        Register register = new Register();
        double userValue = 0.0; //User input variable
        Purse tempPurse; //Creates an empty Purse to retrieve from register.makeChange method
        String printString; //Collects the string from the purse toTheString method to print out

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a value to insert to the purse: ");
        userValue = scan.nextDouble();

        //tempPurse gets set to the purse that is created by register
        tempPurse = register.makeChange(userValue);
        //Just collects the string from the method toTheString which creates a string based on a map
        printString = tempPurse.toString();

        System.out.println(printString);
        
        System.out.println("The Purse value is: " + tempPurse.getValue());



    }

}
