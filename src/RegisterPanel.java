import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    Register register = new Register();
    Purse guiPurse = new Purse();
    JPanel inputPanel = new JPanel();
    JTextField guideInput = new JTextField(1);
    JTextField input = new JTextField(1);
    PursePanel pursePanel = new PursePanel();

    public RegisterPanel() {
        this.setLayout(null);
        inputPanel.setSize(20000,200);
        inputPanel.setLocation(0,0);
        inputPanel.setBackground(Color.GRAY);
        this.add(inputPanel);
        input.setSize(800,100);
        input.setLocation(550,50);
        input.setBackground(Color.GREEN);
        InputListener inputListener = new InputListener();
        input.addActionListener(inputListener);
        //test
        guideInput.setSize(300,50);
        guideInput.setLocation(250,75);
        guideInput.setBackground(Color.pink);
        guideInput.setEditable(false);
        guideInput.setText("Enter a value to convert to change and press enter:");
        this.add(guideInput);
        this.add(input);
        this.add(pursePanel);


    }


    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //What happens when input changes
            //System.out.println("The value the user inserted is: " + Double.parseDouble(e.getActionCommand()));
            guiPurse = register.makeChange(Double.parseDouble(e.getActionCommand()));
            pursePanel.setPurse(guiPurse);
        }
    }


}
