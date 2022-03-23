
import javax.swing.*;
import java.awt.event.ActionEvent;

public class WasdAction extends AbstractAction {
    private Movement movement;

    public WasdAction(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        PressedKeysHolder.pressedKeys.put(movement, true);
    }
}
