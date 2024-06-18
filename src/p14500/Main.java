package p14500;

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
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);

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

    private static class Calculator {

        int[][] board;
        boolean[][] isVisited;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;

        public Calculator(int[][] board) {
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
        }

        public int getResult() {
            calc();
            return result;
        }

        private void calc() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    isVisited[i][j] = true;
                    explore(i, j, board[i][j], 1);
                    isVisited[i][j] = false;
                }
            }
        }

        private void explore(int x, int y, int sum, int cnt) {
            if (cnt == 4) {
                result = Math.max(result, sum);
                return;
            }

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (isWithinBoard(nx, ny) && !isVisited[nx][ny]) {

                    if (cnt == 2) {
                        isVisited[nx][ny] = true;
                        explore(x, y, sum + board[nx][ny], cnt + 1);
                        isVisited[nx][ny] = false;
                    }

                    isVisited[nx][ny] = true;
                    explore(nx, ny, sum + board[nx][ny], cnt + 1);
                    isVisited[nx][ny] = false;
                }
            }
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
        }

    }
}
