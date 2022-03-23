import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ghost implements Character {
    int positionX;
    int positionY;
    LocalDateTime startTime = LocalDateTime.now();

    public Ghost(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    private void destroy(GridElement[][] grid) throws RuntimeException {
        if (ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) >= 5) {
            grid[positionX][positionY] = new Ground();
            throw new RuntimeException("Break");
        }
    }
    @Override
    public void move(GridElement[][] grid) {
        try {
            destroy(grid);
        } catch (RuntimeException e) {
            return;
        }

        int newXPosition = positionX;
        int newYPosition = positionY;
        do {
            double rand = Math.random();
            if (rand <= 0.25) {
                newXPosition = positionX + 1;
            } else if (rand <= 0.50) {
                newXPosition = positionX - 1;
            } else if (rand <= 0.75) {
                newYPosition = positionY + 1;
            } else {
                newYPosition = positionY - 1;
            }
        } while (!isPositionLegal(newXPosition, newYPosition, grid));
        try {
            if (grid[newXPosition][newYPosition] instanceof Pacman) {
                System.out.println("YOU LOST!");
                System.exit(0);
            } else if (grid[newXPosition][newYPosition] instanceof Wall) {
                return;
            }
            grid[newXPosition][newYPosition] = this;
            grid[positionX][positionY] = new Ground();
            positionX = newXPosition;
            positionY = newYPosition;
        } catch (ArrayIndexOutOfBoundsException e) { }
    }

    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        Shape rightWing = new QuadCurve2D.Double(x + GameGrid.CELL_SIZE / 2, y, x + GameGrid.CELL_SIZE, y, x + GameGrid.CELL_SIZE, y + GameGrid.CELL_SIZE);
        Shape leftWing = new QuadCurve2D.Double(x, y + GameGrid.CELL_SIZE, x, y, x + GameGrid.CELL_SIZE / 2, y);
        Shape bottom = new Line2D.Double(x, y + GameGrid.CELL_SIZE, x + GameGrid.CELL_SIZE, y + GameGrid.CELL_SIZE);
        g.setPaint(Color.GREEN);
        g.draw(rightWing);
        g.draw(leftWing);
        g.draw(bottom);
    }

    private boolean isPositionLegal(int posX, int posY, GridElement[][] grid) {
        return posX != positionX || posY != positionY;
    }

}
