import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purseGui;
    //Declare constant variables for display purposes on dimensions of currency
    static final int BILL_WIDTH = 200;
    static final int BILL_HEIGHT = 75;
    static final int COIN_SIDE_LENGTH = 100;
    static final int CURRENCY_OFFSET_Y = 50;
    static final int BILL_OFFSET_X = 200;
    static final int COIN_OFFSET_X = 100;
    //Stored image string in descending order, chose array for sorting reasons
    private BufferedImage[] ImageGen = new BufferedImage[10];


    //Future image placing use
    int positionX = 0;
    int positionY = 0;

    public void setPurse(Purse p) {
        purseGui = p;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        positionY = 0;
        positionX = 0;
        if (purseGui != null) {
            //Array keeps the descending order values from $100 to penny for future sorting use
            double[] descendingValuesArray = {100.00, 50.00, 20.00, 10.00, 5.00, 1.00, .25, .10, .05, .01};

            //Width and Height are decided based on rather it is a dollar or coin
            int width = 0;
            int height = 0;

            //Loops through the array of values declared above (descending from 100 bill to penny)
            for (int i = 0; i < descendingValuesArray.length; i++) {

                //Loops through each entry until the denomination amt matches the value in the descendingValuesArray (this sorts highest to lowest for gui)
                for (Map.Entry<Denomination, Integer> individualSet : purseGui.cash.entrySet()) {

                    double dollarValue = individualSet.getKey().amt(); //Just pulls the amt value from the currently observed denomination
                    if (dollarValue == descendingValuesArray[i]) {
                        //Loops through how many times you have that dollar/coin and displays
                        for (int u = 0; u < individualSet.getValue(); u++) {
                            //Graphic choice
                            if (individualSet.getKey().form() == "bill") {
                                width = BILL_WIDTH;
                                height = BILL_HEIGHT;
                            } else {
                                width = COIN_SIDE_LENGTH;
                                height = COIN_SIDE_LENGTH;
                            }
                            g.drawImage(ImageGen[i], positionX, positionY, width, height, this);
                            positionY += CURRENCY_OFFSET_Y; //Purposely made it where the currency stacks on top of each other so that more can fit
                        }
                        if (individualSet.getKey().form() == "bill") {
                            positionX += BILL_OFFSET_X;
                        } else {
                            positionX += COIN_OFFSET_X;
                        }

                        positionY = 0;
                    }
                }
            }
        }
    }


    private PursePanel(BufferedImage[] ImageStrings) throws RuntimeException {
        setLayout(null);
        setBackground(Color.darkGray);
        setSize(2000,1000);
        setLocation(0,210);

        /*
        IMPLEMENTS FACTORY METHOD
         */
        this.ImageGen = ImageStrings;

    }

    /*
    IMPLEMENT FACTORY METHOD PATTERN
     */

    public static PursePanel createPurseWithImages(Denomination...ImageStrings) {
        BufferedImage[] images = new BufferedImage[10];

        try {
            for (int i = 0; i < images.length; i++) {
                images[i] = ImageIO.read(new File(ImageStrings[i].img()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new PursePanel(images);

    }

}
