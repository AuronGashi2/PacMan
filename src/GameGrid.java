import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameGrid {
    public static int CELL_SIZE = 100;

    private GridElement[][] grid;

    public GameGrid() {
        this.grid = new GridElement[][]{
                {new Pacman(0, 0), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Point(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Point(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point()},
                {new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point(), new Wall(), new Point()}
        };
        Thread ghostThread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        sleep(5000);
                        int ghostCounter = 0;
                        do {
                            int i = (int) Math.floor(11 * Math.random());
                            int j = (int) Math.floor(11 * Math.random());
                            if (grid[i][j] instanceof Ground || grid[i][j] instanceof Point) {
                                grid[i][j] = new Ghost(i, j);
                                ghostCounter++;
                            }
                        } while (ghostCounter < 5);

                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted for something");
                }
            }
        };
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        sleep(500);
                        for (int i = 0; i < grid.length; i++) {
                            GridElement[] row = grid[i];
                            for (int j = 0; j < row.length; j++) {
                                GridElement element = row[j];
                                if (element instanceof Character) {
                                    ((Character) element).move(grid);
                                    break;
                                }
                            }
                        }
                        if (checkWin()) {
                            System.out.println("YOU WIN!");
                            System.exit(0);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Thread Interrupted");
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ghostThread);
        executorService.submit(thread);
    }

    public GridElement[][] getGrid() {
        return grid;
    }

    public void setGrid(GridElement[][] grid) {
        this.grid = grid;
    }

    public boolean checkWin() {
        for (GridElement[] row : grid) {
            for (GridElement element : row) {
                if (element instanceof Point) {
                    return false;
                }
            }
        }
        return true;
    }
}
