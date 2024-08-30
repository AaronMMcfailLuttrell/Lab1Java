import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1200,800);
        frame.setSize(2000,1200);
        frame.setVisible(true);
    }
}
