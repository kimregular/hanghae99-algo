package p2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private final int[][] field;
    private boolean[][] outSide;
    private final Queue<int[]> q;
    private int result;

    public Calculator(int[][] field) {
        this.field = field;
        this.outSide = new boolean[field.length][field[0].length];
        this.q = new ArrayDeque<>();
        this.result = 0;
    }

    public int getResult() {
        init();
        while (!q.isEmpty()) {
            checkOutSide();
            meltCheese();
            postProcess();
            result++;
        }
        return result;
    }

    private void init() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if(field[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
    }


    private void checkOutSide() {
        outSide = new boolean[field.length][field[0].length];
        outSide[0][0] = true;
        Queue<int[]> outSideQ = new ArrayDeque<>();
        outSideQ.offer(new int[]{0, 0});

        while (!outSideQ.isEmpty()) {
            int[] cur = outSideQ.poll();

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinField(nx, ny) && field[nx][ny] == 0 && !outSide[nx][ny]) {
                    outSide[nx][ny] = true;
                    outSideQ.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private void meltCheese() {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            int[] cur = q.poll();

            int heat = 0;
            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinField(nx, ny) && outSide[nx][ny]) {
                    heat++;
                }
            }
            if(heat > 1) field[cur[0]][cur[1]] = -1;
            else q.offer(cur);
        }
    }

    private void postProcess() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if(field[i][j] == -1) field[i][j] = 0;
            }
        }
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < field.length && 0 <= y && y < field[x].length;
    }
}