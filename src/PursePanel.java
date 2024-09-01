import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purseGui;

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
        //g.drawImage(hundred, 0, 0, 300, 200, this);
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
                                width = 200;
                                height = 75;
                            } else {
                                width = 100;
                                height = 100;
                            }
                            g.drawImage(ImageGen[i], positionX, positionY, width, height, this);
                            positionY += 50; //Purposely made it where the currency stacks on top of each other so that more can fit
                        }
                        if (individualSet.getKey().form() == "bill") {
                            positionX += 200;
                        } else {
                            positionX += 100;
                        }

                        positionY = 0;
                    }
                }
            }
        }
    }


    PursePanel(Denomination...ImageStrings) throws RuntimeException {
        setLayout(null);
        setBackground(Color.darkGray);
        setSize(2000,1000);
        setLocation(0,210);

        //Following code sets the image for each BufferedImage
        try {
            ImageGen[0] = ImageIO.read(new File(ImageStrings[0].img()));
            ImageGen[1] = ImageIO.read(new File(ImageStrings[1].img()));
            ImageGen[2] = ImageIO.read(new File(ImageStrings[2].img()));
            ImageGen[3] = ImageIO.read(new File(ImageStrings[3].img()));
            ImageGen[4] = ImageIO.read(new File(ImageStrings[4].img()));
            ImageGen[5] = ImageIO.read(new File(ImageStrings[5].img()));
            ImageGen[6] = ImageIO.read(new File(ImageStrings[6].img()));
            ImageGen[7] = ImageIO.read(new File(ImageStrings[7].img()));
            ImageGen[8] = ImageIO.read(new File(ImageStrings[8].img()));
            ImageGen[9] = ImageIO.read(new File(ImageStrings[9].img()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
