import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        //What happens when input changes
        System.out.println(e.getActionCommand());
    }
}
