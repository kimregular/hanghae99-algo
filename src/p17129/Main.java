package p17129;

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
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] board = new int[n][m];

        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        return board;
    }
}

class Solution {

    public String solution(int[][] board) {
        Calculator c = new Calculator(board);
        return c.getAnswer();
    }

    private class Calculator {

        int[][] board;
        boolean[][] isVisited;
        int[] startLocation;
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};


        public Calculator(int[][] board) {
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
            init();
        }

        private void init() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 2) {
                        startLocation = new int[]{i, j};
                        return;
                    }
                }
            }
        }

        public String getAnswer() {
            int result = BFS();
            if (result == -1) {
                return "NIE";
            }

            return getAnswer(result);
        }

        private String getAnswer(int num) {
            StringBuilder answer = new StringBuilder();
            return answer.append("TAK").append("\n").append(num).toString();
        }

        private int BFS() {
            Queue<Location> q = new ArrayDeque<>();
            q.offer(new Location(startLocation[0], startLocation[1], 0));
            isVisited[startLocation[0]][startLocation[1]] = true;

            while (!q.isEmpty()) {
                Location current = q.poll();

                if (board[current.x][current.y] != 0 && board[current.x][current.y] != 2) {
                    return current.step;
                }

                for (int[] direction : directions) {
                    int nx = current.x + direction[0];
                    int ny = current.y + direction[1];

                    if (isWithinBoard(nx, ny) && board[nx][ny] != 1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Location(nx, ny, current.step + 1));
                    }
                }
            }
            return -1;
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
        }

        private class Location {
            int x;
            int y;
            int step;

            public Location(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }
    }
}