import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GamePanel extends JPanel {
    private GameGrid grid = new GameGrid();
    LocalDateTime startTime = LocalDateTime.now();

    public GamePanel() {
        System.out.println(PressedKeysHolder.pressedKeys.get(Movement.DOWN));
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap ap = getActionMap();
        putKeyBinding(im, ap, Movement.DOWN);
        putKeyBinding(im, ap, Movement.UP);
        putKeyBinding(im, ap, Movement.LEFT);
        putKeyBinding(im, ap, Movement.RIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Graphics2D g1 = (Graphics2D) g;

        for (int i = 0; i < grid.getGrid().length; i++) {
            GridElement[] row = grid.getGrid()[i];
            for (int j = 0; j < row.length; j++) {
                GridElement element = row[j];
                element.drawShape(i*GameGrid.CELL_SIZE, j*GameGrid.CELL_SIZE, g1);
            }
        }
        g1.setPaint(Color.WHITE);
        g1.fillRect(MyFrame.width/2, 30, 70, 40);
        g1.setPaint(Color.BLACK);
        g.drawString("Score: " + Score.getScore(), MyFrame.width/2, 50);
        g.drawString("Seconds: " + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()), MyFrame.width/2, 60);
        repaint();
    }

    private void putKeyBinding(InputMap inputMap, ActionMap actionMap, Movement movement) {
        inputMap.put(KeyStroke.getKeyStroke(movement.getKeycode(), 0, false), movement);
        actionMap.put(movement, new WasdAction(movement));
    }
}
