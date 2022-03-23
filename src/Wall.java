
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall implements GridElement {
    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        Shape shape = new Rectangle2D.Double(x, y, GameGrid.CELL_SIZE, GameGrid.CELL_SIZE);
        g.setPaint(Color.BLUE);
        g.fill(shape);
    }
}
