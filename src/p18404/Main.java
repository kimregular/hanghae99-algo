package p18404;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.board, ip.knight, ip.targets));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int[][] targets = new int[m][2];

        int[][] board = new int[n + 1][n + 1];
        int[] knight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < targets.length; i++) {
            targets[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return new Input(board, knight, targets);
    }

    private static class Input {

        int[][] board;
        int[] knight;
        int[][] targets;

        public Input(int[][] board, int[] knight, int[][] targets) {
            this.board = board;
            this.knight = knight;
            this.targets = targets;
        }
    }
}

class Solution {

    public String solution(int[][] board, int[] knight, int[][] targets) {
        Calculator c = new Calculator(board, knight, targets);
        return c.getResult();
    }

    private class Calculator {

        int[][] board;
        boolean[][] isVisited;
        int[] knight;
        int[][] targets;
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int[] result;

        public Calculator(int[][] board, int[] knight, int[][] targets) {
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
            this.knight = knight;
            this.targets = targets;
            this.result = new int[targets.length];
        }

        public String getResult() {
            for (int[] target : targets) {
                board[target[0]][target[1]] = -1;
            }
            BFS();
            return getAnswer(result);
        }

        private String getAnswer(int[] arr) {
            StringBuilder answer = new StringBuilder();
            for (int num : arr) {
                answer.append(num).append(" ");
            }
            return answer.toString();
        }

        private void BFS() {
            Queue<Location> q = new ArrayDeque<>();
            q.offer(new Location(knight[0], knight[1], 0));
            isVisited[knight[0]][knight[1]] = true;

            while (!q.isEmpty()) {
                Location currentLocation = q.poll();
                int currentX = currentLocation.x;
                int currentY = currentLocation.y;
                int currentStep = currentLocation.step;

                if (board[currentX][currentY] == -1) {
                    addResult(currentX, currentY, currentStep);
                }

                for (int[] direction : directions) {
                    int nx = currentX + direction[0];
                    int ny = currentY + direction[1];

                    if (isWithinBoard(nx, ny) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Location(nx, ny, currentStep + 1));
                    }
                }
            }
        }

        private void addResult(int x, int y, int curStep) {
            for (int i = 0; i < targets.length; i++) {
                int[] candidate = targets[i];

                if (candidate[0] == x && candidate[1] == y) {
                    result[i] = curStep;
                    return;
                }
            }
        }

        private boolean isWithinBoard(int x, int y) {
            return 1 <= x && x < board.length && 1 <= y && y < board[x].length;
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
