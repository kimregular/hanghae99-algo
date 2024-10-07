package p3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        char[][] result = new char[len][len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine().toCharArray();
        }
        return result;
    }
}

class Solution {

    public int solution(char[][] input) {
        Bomboni bomboni = new Bomboni(new CandyBoard(input));
        return bomboni.getGameResult();
    }
}

class Bomboni {

    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private final CandyBoard candyBoard;
    private int maxNumOfCandyDelete;

    public Bomboni(CandyBoard candyBoard) {
        this.candyBoard = candyBoard;
        this.maxNumOfCandyDelete = 0;
    }

    public int getGameResult() {
        play();
        return maxNumOfCandyDelete;
    }

    private void play() {
        int len = candyBoard.getCandies().length;
        checkNumOfDeletedCandies();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                for (int[] direction : directions) {
                    int nx = i + direction[0];
                    int ny = j + direction[1];

                    if (candyBoard.isWithinCandyBoard(nx, ny) && candyBoard.isDifferentCandy(i, j, nx, ny)) {
                        candyBoard.switchCandy(i, j, nx, ny);
                        checkNumOfDeletedCandies();
                        candyBoard.switchCandy(nx, ny, i, j);
                    }
                }
            }
        }
    }

    private void checkNumOfDeletedCandies() {
        int len = candyBoard.getCandies().length;

        for (int i = 0; i < len; i++) {
            int rowLen = 0;
            char rowPrev = ' ';
            int colLen = 0;
            char colPrev = ' ';
            for (int j = 0; j < len; j++) {
                if (candyBoard.getCandy(i, j) != rowPrev) {
                    rowPrev = candyBoard.getCandy(i, j);
                    rowLen = 1;
                } else {
                    rowLen++;
                }

                if (candyBoard.getCandy(j, i) != colPrev) {
                    colPrev = candyBoard.getCandy(j, i);
                    colLen = 1;
                } else {
                    colLen++;
                }
                maxNumOfCandyDelete = Math.max(maxNumOfCandyDelete, Math.max(rowLen, colLen));
            }
        }
    }

}

class CandyBoard {

    private char[][] candies;

    public CandyBoard(char[][] candies) {
        this.candies = candies;
    }

    public char[][] getCandies() {
        return candies;
    }

    public char getCandy(int x, int y) {
        return candies[x][y];
    }

    public void switchCandy(int fromX, int fromY, int toX, int toY) {
        char temp = candies[toX][toY];
        candies[toX][toY] = candies[fromX][fromY];
        candies[fromX][fromY] = temp;
    }

    public boolean isWithinCandyBoard(int x, int y) {
        int len = candies.length;
        return 0 <= x && x < len && 0 <= y && y < len;
    }

    public boolean isDifferentCandy(int fromX, int fromY, int targetX, int targetY) {
        return candies[fromX][fromY] != candies[targetX][targetY];
    }
}