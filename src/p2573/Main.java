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
        return c.calculateYearsUntilSplit();
    }
}

class Calculator {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private final int[][] field;
    private final Queue<int[]> q;
    private int yearsToSplit;
    private boolean isSplited;

    public Calculator(int[][] field) {
        this.field = field;
        this.q = new ArrayDeque<>();
        this.yearsToSplit = 0;
        this.isSplited = false;
    }

    public int calculateYearsUntilSplit() {
        initQueue();
        while (!q.isEmpty()) {
            if (isGlacierSplit()) {
                return yearsToSplit;
            }
            meltGlacier();
            yearsToSplit++;
        }
        return 0;
    }

    private void meltGlacier() {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            int[] cur = q.poll();
            int glacierHeight = field[cur[0]][cur[1]];
            int meltAmount = getMeltAmount(cur);
            field[cur[0]][cur[1]] = glacierHeight - meltAmount;
            if (glacierHeight - meltAmount > 0) {
                q.offer(cur);
            } else {
                field[cur[0]][cur[1]] = -1;
            }
        }
        postProcess();
    }

    private void initQueue() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) continue;
                q.offer(new int[]{i, j});
            }
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

    private int getMeltAmount(int[] cur) {
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

    private boolean isGlacierSplit() {
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