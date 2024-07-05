package p2206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[tokens[0]][tokens[1]];
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
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
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean isReachable = false;
        int result = 10000;

        public Calculator(int[][] board) {
            this.boardOrigin = board;
        }

        public int getResult() {
            explore();
            breakWallAndExplore(0);
            if(isReachable) return result;
            return -1;
        }

        private void breakWallAndExplore(int cnt) {
            if (cnt == 1) {
                explore();
                return;
            }

            for (int i = 0; i < boardOrigin.length; i++) {
                for (int j = 0; j < boardOrigin[i].length; j++) {
                    if (boardOrigin[i][j] == 1) {
                        boardOrigin[i][j] = 0;
                        breakWallAndExplore(cnt + 1);
                        boardOrigin[i][j] = 1;
                    }
                }
            }

        }

        private void explore() {
            int[][] isVisited = new int[boardOrigin.length][boardOrigin[0].length];
            Queue<Point> q = new ArrayDeque<>();
            q.offer(new Point(0, 0, 1));
            isVisited[0][0] = 1;

            while (!q.isEmpty()) {
                Point current = q.poll();

                for (int[] direction : directions) {
                    int nx = current.x + direction[0];
                    int ny = current.y + direction[1];

                    if (isWithinBoard(nx, ny) && isVisited[nx][ny] == 0 && boardOrigin[nx][ny] == 0) {
                        isVisited[nx][ny] = current.step + 1;
                        q.offer(new Point(nx, ny, current.step + 1));
                    }
                }
            }
            if (isVisited[boardOrigin.length - 1][boardOrigin[0].length - 1] != 0) {
                isReachable = true;
                result = Math.min(result, isVisited[boardOrigin.length - 1][boardOrigin[0].length - 1]);
            }


        }

        private boolean isWithinBoard(int x, int y) {
            return 0 <= x && x < boardOrigin.length && 0 <= y && y < boardOrigin[x].length;
        }

        private class Point {
            int x, y, step;

            public Point(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }
    }
}


