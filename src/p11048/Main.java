package p11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        String[] dimension = br.readLine().split(" ");
        int x = Integer.parseInt(dimension[0]);
        int y = Integer.parseInt(dimension[1]);
        int[][] board = new int[x][y];

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return board;
    }
}

class Solution {

    public int solution(int[][] board) {
        Calculator c = new Calculator(board);
        return c.getResult();
    }
}

class Calculator {

    int[][] board;
    int[][] candies;
    int[][] directions = {{0, -1}, {-1, -1}, {-1, 0}};

    public Calculator(int[][] board) {
        this.board = board;
        this.candies = new int[board.length][board[0].length];
    }

    public int getResult() {
        calc();
        return candies[candies.length - 1][candies[0].length - 1];
    }

    private void calc() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                candies[i][j] = getCandySum(i, j);
            }
        }
    }

    private int getCandySum(int x, int y) {
        int sumOfCandy = board[x][y];

        int target = 0;
        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (isWithinBoard(nx, ny)) {
                target = Math.max(target, candies[nx][ny]);
            }
        }
        return sumOfCandy + target;
    }

    private boolean isWithinBoard(int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
    }
}