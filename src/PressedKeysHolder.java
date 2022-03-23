

import java.util.HashMap;
import java.util.Map;

public class PressedKeysHolder {
    public static Map<Movement, Boolean> pressedKeys = new HashMap<>();

    public PressedKeysHolder() {
        reset();
    }

    public static void reset() {
        pressedKeys.put(Movement.DOWN, false);
        pressedKeys.put(Movement.RIGHT, false);
        pressedKeys.put(Movement.LEFT, false);
        pressedKeys.put(Movement.UP, false);
    }
}
