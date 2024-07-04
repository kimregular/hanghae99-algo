package p14502;

import java.io.*;
import java.util.*;

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
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[tokens[0]][tokens[1]];

        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return board;
    }
}

class Solution {

    public int solution(int[][] board) {
        Calculator c = new Calculator(board);
        return c.getResult();
    }

    private class Calculator {

        int[][] boardOrigin;
        Queue<Virus> qOrigin = new ArrayDeque<>();
        int result = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public Calculator(int[][] boardOrigin) {
            this.boardOrigin = boardOrigin;
            virusInit();
        }

        public int getResult() {
            explore();
            return result;
        }

        private void explore() {
            buildWalls(0);
        }

        private void buildWalls(int cnt) {
            if (cnt == 3) {
                infectAndCalc();
                return;
            }

            for (int i = 0; i < boardOrigin.length; i++) {
                for (int j = 0; j < boardOrigin[i].length; j++) {
                    if (boardOrigin[i][j] == 0) {
                        boardOrigin[i][j] = 1;
                        buildWalls(cnt + 1);
                        boardOrigin[i][j] = 0;
                    }
                }
            }
        }

        private void infectAndCalc() {
            int[][] board = copy();
            Queue<Virus> q = new ArrayDeque<>(qOrigin);

            while (!q.isEmpty()) {
                Virus current = q.poll();

                for (int[] direction : directions) {
                    int nx = current.x + direction[0];
                    int ny = current.y + direction[1];

                    if (isWithinBoard(nx, ny) && board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                        q.offer(new Virus(nx, ny));
                    }
                }
            }
            getSafeZone(board);
        }

        private void getSafeZone(int[][] board) {
            int temp = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) temp++;
                }
            }
            result = Math.max(result, temp);
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < boardOrigin.length && 0 <= y && y < boardOrigin[x].length;
        }

        private int[][] copy() {
            int[][] result = new int[boardOrigin.length][boardOrigin[0].length];
            for (int i = 0; i < result.length; i++) {
                result[i] = boardOrigin[i].clone();
            }
            return result;
        }

        private void virusInit() {
            for (int i = 0; i < boardOrigin.length; i++) {
                for (int j = 0; j < boardOrigin[i].length; j++) {
                    if(boardOrigin[i][j] == 2) qOrigin.add(new Virus(i, j));
                }
            }
        }

        private class Virus {
            int x;
            int y;

            public Virus(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
