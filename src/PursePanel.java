import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purseGui;
    private BufferedImage hundred;
    private BufferedImage fifty;
    private BufferedImage twenty;
    private BufferedImage ten;
    private BufferedImage five;
    private BufferedImage one;
    private BufferedImage quarter;
    private BufferedImage dime;
    private BufferedImage nickel;
    private BufferedImage penny;
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


            /*
            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                positionY = 0;
                double cashWorth = entryCheck.getKey().amt();
                int amountOfCash = entryCheck.getValue();

                if (cashWorth == 100.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(hundred, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 50.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(fifty, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 20.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(twenty, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 10.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(ten, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 5.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(five, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 1.00) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(one, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 0.25) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(quarter, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 0.10) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(dime, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 0.05) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(nickel, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                } else if (cashWorth == 0.01) {
                    for (int i = 0; i < amountOfCash; i++) {
                        g.drawImage(penny, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                }

                if (cashWorth == 100.00 || cashWorth == 50.00 || cashWorth == 20.00 || cashWorth == 10.00 || cashWorth == 5.00 || cashWorth == 1.00) {
                    positionX += 200;
                } else {
                    positionX += 100;
                }
            } */

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 100.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(hundred, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 50.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(fifty, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 20.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(twenty, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 10.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(ten, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 5.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(five, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == 1.00) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(one, positionX, positionY, 200, 75, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == .25) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(quarter, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == .10) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(dime, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == .05) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(nickel, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

            for (Map.Entry<Denomination, Integer> entryCheck : purseGui.cash.entrySet()) {
                double dollarValue = entryCheck.getKey().amt();
                if (dollarValue == .01) {
                    for (int i = 0; i < entryCheck.getValue(); i++) {
                        g.drawImage(penny, positionX, positionY, 100, 100, this);
                        positionY += 50;
                    }
                    positionY = 0;
                    if (dollarValue == 100.00 || dollarValue == 50.00 || dollarValue == 20.00 || dollarValue == 10.00 || dollarValue == 5.00 || dollarValue == 1.00) {
                        positionX += 200;
                    } else {
                        positionX += 100;
                    }
                }
            }

        }

    }


    PursePanel() {
        setLayout(null);
        setBackground(Color.darkGray);
        setSize(2000,1000);
        setLocation(0,210);

        //Following code sets the image for each BufferedImage
        try {
            hundred = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\HundredNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fifty = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\FiftyNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            twenty = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\TwentyNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ten = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\TenNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            five = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\FiveNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            one = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\OneNote.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            quarter = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\Quarter.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dime = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\Dime.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            nickel = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\Nickel.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            penny = ImageIO.read(new File("C:\\Users\\aaron\\IdeaProjects\\Lab1Java\\src\\Penny.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
