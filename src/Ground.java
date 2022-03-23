import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Ground implements GridElement{
    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        drawGround(x, y, g);
    }

    public static void drawGround(int x, int y, Graphics2D g) {
        Shape ground = new Rectangle2D.Double(x, y, GameGrid.CELL_SIZE, GameGrid.CELL_SIZE);
        g.setPaint(Color.BLACK);
        g.fill(ground);
    }
}
