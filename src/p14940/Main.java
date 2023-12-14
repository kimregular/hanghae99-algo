package p14940;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[][] board = new int[x][y];

            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < y; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Solution s = new Solution(board);
            StringBuilder answer = new StringBuilder();
            for (int[] ints : s.getBoard()) {
                for (int z : ints) {
                    answer.append(z).append(" ");
                }
                answer.append("\n");
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[][] board;
    boolean[][] isVisited;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] result;

    public Solution(int[][] board) {
        this.board = board;
        this.isVisited = new boolean[board.length][board[0].length];
        this.result = new int[board.length][board[0].length];
    }

    public int[][] getBoard() {
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == 0) {
                    this.isVisited[i][j] = true;
                } else if (this.board[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        return BFS(startX, startY);
    }

    private int[][] BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        this.isVisited[x][y] = true;
        this.result[x][y] = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();
                int nextStep = currentPoint.step + 1;

                for (int[] direction : directions) {
                    int nx = currentPoint.x + direction[0];
                    int ny = currentPoint.y + direction[1];

                    if (isWithinBoard(nx, ny) && !this.isVisited[nx][ny] && this.board[nx][ny] == 1) {
                        this.isVisited[nx][ny] = true;
                        this.result[nx][ny] = nextStep;
                        q.offer(new Point(nx, ny, nextStep));
                    }
                }
            }
        }
        return validBoard();
    }

    private int[][] validBoard() {
        for (int i = 0; i < this.result.length; i++) {
            for (int j = 0; j < this.result[i].length; j++) {
                if (this.result[i][j] == 0) {
                    if (!this.isVisited[i][j]) {
                        this.result[i][j] = -1;
                    }
                }
            }
        }

        return this.result;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < this.board.length && y >= 0 && y < this.board[x].length;
    }
}

class Point {
    int x;
    int y;
    int step;

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}