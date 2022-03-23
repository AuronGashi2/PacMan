

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;

public class TestElement implements GridElement{
    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        Shape shape = new Line2D.Double(0 + x, 0 + y, 50 + x, 50 + y);
        g.setPaint(Color.RED);
        g.draw(shape);
    }
}
