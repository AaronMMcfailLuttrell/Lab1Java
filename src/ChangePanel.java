import javax.swing.*;
import java.awt.*;

public class ChangePanel extends JPanel {
    Purse purse = new Purse();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        setSize(200,300);
    }
}
