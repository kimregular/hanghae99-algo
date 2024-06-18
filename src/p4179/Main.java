package p4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] board = new String[tokens[0]][tokens[1]];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().split("");
        }
        return board;
    }
}

class Solution {

    public String solution(String[][] board) {
        Calculator c = new Calculator(board);
        return c.getResult();
    }

    private static class Calculator {

        String[][] board;
        int[][] fireBoard;
        int[][] humanBoard;
        boolean[][] isHumanVisited;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = Integer.MAX_VALUE;

        public Calculator(String[][] board) {
            this.board = board;
            this.fireBoard = new int[board.length][board[0].length];
            this.humanBoard = new int[board.length][board[0].length];
            this.isHumanVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                Arrays.fill(fireBoard[i], -1);
                Arrays.fill(humanBoard[i], -1);
            }
        }

        public String getResult() {
            fireExplore();
            humanExplore();
            if (result == Integer.MAX_VALUE) return "IMPOSSIBLE";
            return String.valueOf(result);
        }

        private void humanExplore() {
            Queue<Position> q = initPosition("J");

            while (!q.isEmpty()) {
                Position currentPosition = q.poll();

                for (int[] direction : directions) {
                    int nx = currentPosition.x + direction[0];
                    int ny = currentPosition.y + direction[1];
                    int nextStep = currentPosition.step + 1;

                    if (!isWithinBoard(nx, ny)) {
                        result = Math.min(result, nextStep);
                        return;
                    }

                    if (isWithinBoard(nx, ny) && board[nx][ny].equals(".") && !isHumanVisited[nx][ny]) {
                        if (fireBoard[nx][ny] == -1 || nextStep < fireBoard[nx][ny]) {
                            isHumanVisited[nx][ny] = true;
                            humanBoard[nx][ny] = nextStep;
                            q.offer(new Position(nx, ny, nextStep));
                        }
                    }

                }
            }
        }

        private void fireExplore() {
            Queue<Position> q = initPosition("F");

            while (!q.isEmpty()) {
                Position currentPosition = q.poll();

                for (int[] direction : directions) {
                    int nx = currentPosition.x + direction[0];
                    int ny = currentPosition.y + direction[1];
                    int nextStep = currentPosition.step + 1;

                    if (isWithinBoard(nx, ny) && board[nx][ny].equals(".") && fireBoard[nx][ny] == -1) {
                        fireBoard[nx][ny] = nextStep;
                        q.offer(new Position(nx, ny, nextStep));
                    }
                }
            }
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
        }

        private Queue<Position> initPosition(String target) {
            Queue<Position> result = new ArrayDeque<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals(target)) {
                        if (target.equals("F")) {
                            fireBoard[i][j] = 0;
                        } else {
                            humanBoard[i][j] = 0;
                        }
                        result.offer(new Position(i, j, 0));
                    }
                }
            }
            return result;
        }

        private class Position {

            int x;
            int y;
            int step;

            public Position(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }
    }
}