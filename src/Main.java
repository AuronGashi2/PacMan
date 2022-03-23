import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new PressedKeysHolder();
        JFrame jFrame = new MyFrame();
        JPanel jPanel = new GamePanel();
        jFrame.getContentPane().add(jPanel);
        jFrame.setVisible(true);
    }
}
