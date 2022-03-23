

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Point implements GridElement {
    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        Ground.drawGround(x, y, g);
        g.setPaint(Color.YELLOW);
        Shape point = getEllipseFromCenter((double) (x + GameGrid.CELL_SIZE/2), (double) (y + GameGrid.CELL_SIZE/2), (double) (GameGrid.CELL_SIZE/10), (double) (GameGrid.CELL_SIZE/10));
        g.fill(point);
    }

    private Ellipse2D getEllipseFromCenter(double x, double y, double width, double height)
    {
        double newX = x - width / 2.0;
        double newY = y - height / 2.0;

        Ellipse2D ellipse = new Ellipse2D.Double(newX, newY, width, height);

        return ellipse;
    }
}
