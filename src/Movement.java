import java.awt.event.KeyEvent;

public enum Movement {
    UP(KeyEvent.VK_W),
    DOWN(KeyEvent.VK_S),
    LEFT(KeyEvent.VK_A),
    RIGHT(KeyEvent.VK_D);

    private int keycode;

    Movement(int keycode) {
        this.keycode = keycode;
    }

    public int getKeycode() {
        return this.keycode;
    }
}
