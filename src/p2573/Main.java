package p2573;

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

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private final int[][] field;
    private final Queue<int[]> q;
    private int result;
    private boolean isSplited;

    public Calculator(int[][] field) {
        this.field = field;
        this.q = new ArrayDeque<>();
        this.result = 0;
        this.isSplited = false;
    }

    public int getResult() {
        init();
        calc();
        return isSplited ? result : 0;
    }

    private void init() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) continue;
                q.offer(new int[]{i, j});
            }
        }
    }

    private void calc() {
        while (!q.isEmpty()) {
            if (isTwo()) return;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int value = field[cur[0]][cur[1]];
                int minus = getMinus(cur);
                field[cur[0]][cur[1]] = value - minus;
                if (value - minus > 0) {
                    q.offer(cur);
                } else {
                    field[cur[0]][cur[1]] = -1;
                }
            }
            postProcess();
            result++;
        }
    }

    private void postProcess() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] < 0) {
                    field[i][j] = 0;
                }
            }
        }
    }

    private int getMinus(int[] cur) {
        int minus = 0;
        for (int[] direction : directions) {
            int nx = cur[0] + direction[0];
            int ny = cur[1] + direction[1];

            if (isWithinField(nx, ny) && field[nx][ny] == 0) {
                minus++;
            }
        }
        return minus;
    }

    private boolean isTwo() {
        int numOfGlacier = 0;
        boolean[][] isChecked = new boolean[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (numOfGlacier > 1){
                    isSplited = true;
                    return isSplited;
                }
                if (field[i][j] != 0 && !isChecked[i][j]) {
                    numOfGlacier++;
                    explore(i, j, isChecked);
                }
            }
        }
        return false;
    }

    private void explore(int x, int y, boolean[][] isChecked) {
        Queue<int[]> exploreQ = new ArrayDeque<>();
        isChecked[x][y] = true;
        exploreQ.offer(new int[]{x, y});

        while (!exploreQ.isEmpty()) {
            int[] cur = exploreQ.poll();

            for (int[] direction : directions) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinField(nx, ny) && !isChecked[nx][ny] && field[nx][ny] > 0) {
                    isChecked[nx][ny] = true;
                    exploreQ.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < field.length && 0 <= y && y < field[x].length;
    }
}