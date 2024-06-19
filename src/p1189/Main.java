package p1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.k, ip.board));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[][] board = new String[r][c];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().split("");
        }
        return new Input(k, board);
    }

    private static class Input {

        int k;
        String[][] board;

        public Input(int k, String[][] board) {
            this.k = k;
            this.board = board;
        }
    }
}

class Solution {

    public int solution(int k, String[][] board) {
        Calculator c = new Calculator(k, board);
        return c.getResult();
    }

    private static class Calculator{

        int k;
        String[][] board;
        boolean[][] isVisited;
        int successedRoute = 0;

        int startX;
        int startY = 0;

        int targetX = 0;
        int targetY;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public Calculator(int k, String[][] board) {
            this.k = k;
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
            this.startX = board.length - 1;
            this.targetY = board[0].length - 1;
        }

        public int getResult() {
            calc();
            return successedRoute;
        }

        private void calc() {
            isVisited[startX][startY] = true;
            explore(startX, startY, 1);
        }

        private void explore(int x, int y, int cnt) {
            if (cnt == k) {
                if (x == targetX && y == targetY) {
                    successedRoute++;
                }
                return;
            }

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (isWithinBoard(nx, ny) && !isVisited[nx][ny] && !board[nx][ny].equals("T")) {
                    isVisited[nx][ny] = true;
                    explore(nx, ny, cnt + 1);
                    isVisited[nx][ny] = false;
                }
            }
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
        }
    }
}
