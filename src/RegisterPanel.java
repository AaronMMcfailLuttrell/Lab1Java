import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterPanel extends JPanel {

    Register register = new Register();

    JPanel inputPanel = new JPanel();

    public RegisterPanel() {
        this.setLayout(null);
        inputPanel.setSize(100,100);
        inputPanel.setLocation(200,200);
        inputPanel.setBackground(Color.BLACK);
        this.add(inputPanel);
        JTextField input = new JTextField(1);
        input.setSize(800,100);
        input.setLocation(200,200);
        input.setBackground(Color.GREEN);
        InputListener inputListener = new InputListener();
        input.addActionListener(inputListener);
        this.add(input);

    }

    PursePanel pursepanel = new PursePanel();

}
