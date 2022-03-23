public class MoveAmount {
    private int moveX;
    private int moveY;

    public MoveAmount() {
        this.moveX = 0;
        this.moveY = 0;
    }

    public MoveAmount(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public void addX(int number) {
        this.moveX+=number;
    }

    public void addY(int number) {
        this.moveY+=number;
    }
}
