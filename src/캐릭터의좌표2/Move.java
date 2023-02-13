package 캐릭터의좌표2;

public class Move {
    public String up = "up";
    public String down = "down";
    public String left = "left";
    public String right = "right";
    public int xPos = 0;
    public int yPos = 1;
    public int maxWidth = 0;
    public int maxHeight= 0;
    int[] answer = {0, 0};

    public void move(String key) {
        if (up.equals(key)) {
            // up
            moveUp();
        } else if (down.equals(key)) {
            // down
            moveDown();
        } else if (left.equals(key)) {
            // left
            moveLeft();
        } else {
            // right
            moveRight();
        }
    }

    public void moveUp() {
        int top = Math.abs(maxHeight);
        if (answer[yPos] + 1 <= top) {
            answer[yPos]++;
        };
    }

    public void moveDown() {
        int bottom = Math.abs(maxHeight) * -1;
        if (answer[yPos] - 1 >= bottom) {
            answer[yPos]--;
        };
    }

    public void moveLeft() {
        int left = Math.abs(maxWidth) * -1;
        if (answer[xPos] - 1 >= left) {
            answer[xPos]--;
        };
    }

    public void moveRight() {
        int right = Math.abs(maxWidth);
        if (answer[xPos] + 1 <= right) {
            answer[xPos]++;
        };
    }
}
