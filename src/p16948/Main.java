package p16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.board, ip.startPoint, ip.targetPoint));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] board = new int[len][len];

        int[] positions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] startPoint = {positions[0], positions[1]};
        int[] targetPoint = {positions[2], positions[3]};

        return new Input(board, startPoint, targetPoint);
    }

    private static class Input {

        int[][] board;
        int[] startPoint;
        int[] targetPoint;

        public Input(int[][] board, int[] startPoint, int[] targetPoint) {
            this.board = board;
            this.startPoint = startPoint;
            this.targetPoint = targetPoint;
        }
    }
}

class Solution {

    public int solution(int[][] board, int[] startPoint, int[] targetPoint) {
        Calculator c = new Calculator(board, startPoint, targetPoint);
        return c.getResult();
    }

    private class Calculator{

        int[][] board;
        boolean[][] isVisited;
        int[] startPoint;
        int[] targetPoint;
        int[][] directions = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

        public Calculator(int[][] board, int[] startPoint, int[] targetPoint) {
            this.board = board;
            this.isVisited = new boolean[board.length][board[0].length];
            this.startPoint = startPoint;
            this.targetPoint = targetPoint;
        }

        public int getResult() {
            return BFS();
        }

        private int BFS() {
            Queue<Point> q = new ArrayDeque<>();
            q.offer(new Point(startPoint[0], startPoint[1], 0));
            isVisited[startPoint[0]][startPoint[1]] = true;

            while (!q.isEmpty()) {
                Point current = q.poll();
                int currentX = current.x;
                int currentY = current.y;
                int currentStep = current.step;

                if (currentX == targetPoint[0] && currentY == targetPoint[1]) {
                    return currentStep;
                }

                for (int[] direction : directions) {
                    int nx = currentX + direction[0];
                    int ny = currentY + direction[1];

                    if (isWithinBoard(nx, ny) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny, currentStep + 1));
                    }
                }
            }
            return -1;
        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < board.length && 0 <= y && y < board[x].length;
        }

        private class Point {

            int x;
            int y;
            int step;

            public Point(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }
    }
}