package p17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
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
        int[][] field = new int[x][y];

        for (int i = 0; i < field.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return field;
    }
}

class Solution {

    public int solution(int[][] field) {
        Calculator c = new Calculator(field);
        return c.getResult();
    }
}

class Calculator {

    int[][] field;
    int[][] distanceField;
    boolean[][] isVisited;
    Queue<Point> q = new ArrayDeque<>();
    int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    int result = 0;

    public Calculator(int[][] field) {
        this.field = field;
        this.distanceField = new int[field.length][field[0].length];
        this.isVisited = new boolean[field.length][field[0].length];
        for (int[] row : distanceField) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

    public int getResult() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    isVisited[i][j] = true;
                    distanceField[i][j] = 0;
                    q.offer(new Point(i, j, 0));
                }
            }
        }
        BFS();
        postProcess();
        return result;
    }

    private void BFS() {
        while (!q.isEmpty()) {
            Point cur = q.poll();

            distanceField[cur.x][cur.y] = cur.step;

            for (int[] direction : directions) {
                int nx = cur.x + direction[0];
                int ny = cur.y + direction[1];

                if (isWithinField(nx, ny) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.step + 1));
                }
            }
        }
    }

    private void postProcess() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                result = Math.max(result, distanceField[i][j]);
            }
        }
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < field.length && 0 <= y && y < field[x].length;
    }

    private static class Point {
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