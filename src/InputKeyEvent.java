import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvent extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_A) {
            System.out.println("Moving A");
        }
    }
}
