import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

public class Pacman implements Character {
    private int positionX;
    private int positionY;

    public Pacman(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public void drawShape(int x, int y, Graphics2D g) {
        Ground.drawGround(x, y, g);
        Shape body = new Ellipse2D.Double(x, y, GameGrid.CELL_SIZE, GameGrid.CELL_SIZE);
        g.setPaint(Color.RED);
        g.fill(body);
    }

    @Override
    public void move(GridElement[][] grid) {
        MoveAmount moveAmount = getMoveAmount();
        try {
            int newXPosition = positionX + moveAmount.getMoveX();
            int newYPosition = positionY + moveAmount.getMoveY();
            if (isPositionLegal(newXPosition, newYPosition, grid)) {
                if (grid[newXPosition][newYPosition] instanceof Point) {
                    Score.increase();
                } else if (grid[newXPosition][newYPosition] instanceof Ghost) {
                    System.out.println("YOU LOST!");
                    System.exit(0);
                } else if (grid[newXPosition][newYPosition] instanceof Wall) {
                    return;
                }
                grid[newXPosition][newYPosition] = this;

                grid[positionX][positionY] = new Ground();
                positionX = newXPosition;
                positionY = newYPosition;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no place you can go");
        }
    }

    private boolean isPositionLegal(int posX, int posY, GridElement[][] grid) {
        return posX != positionX || posY != positionY;
    }

    private MoveAmount getMoveAmount() {
        MoveAmount moveAmount = new MoveAmount();
        if (PressedKeysHolder.pressedKeys.get(Movement.DOWN)) {
            moveAmount.addY(1);
        }
        if (PressedKeysHolder.pressedKeys.get(Movement.UP)) {
            moveAmount.addY(-1);
        }
        if (PressedKeysHolder.pressedKeys.get(Movement.LEFT)) {
            moveAmount.addX(-1);
        }
        if (PressedKeysHolder.pressedKeys.get(Movement.RIGHT)) {
            moveAmount.addX(1);
        }
        PressedKeysHolder.reset();
        return moveAmount;
    }
}





































/*        Map<Integer, Movement> movementMap = new HashMap<>();
        movementMap.put(87, Movement.UP);
        movementMap.put(67, Movement.LEFT);
        movementMap.put(68, Movement.RIGHT);
        movementMap.put(83, Movement.DOWN);
        long eventMask = AWTEvent.KEY_EVENT_MASK;

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent awtEvent) {
                KeyEvent keyEvent = (KeyEvent) awtEvent;
//                Movement movement = movementMap.get(keyEvent.getKeyCode());
//                System.out.println(awtEvent);
//                System.out.println(movement);
                if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
                    Movement movement = movementMap.get(keyEvent.getKeyCode());
                    if (movement != null) {
//                        move(movement, new GameGrid(new GridElement[][]{{}}));
                    }
                }
            }
        }, eventMask);*/