package p31946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.field, ip.jump));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input readInput(BufferedReader br) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int[][] field = new int[x][y];

        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int jump = Integer.parseInt(br.readLine());

        return new Input(field, jump);
    }


    private static class Input {

        private final int[][] field;
        private final int jump;

        public Input(int[][] field, int jump) {
            this.field = field;
            this.jump = jump;
        }
    }
}

class Solution {


    public String solution(int[][] field, int jump) {
        PathFinder pf = new PathFinder(field, jump);
        return pf.getResult();
    }


}

class PathFinder {

    private final int[][] field;
    private final int xLimit;
    private final int yLimit;
    private final boolean[][] isVisited;
    private final int startColor;
    private final int jump;

    public PathFinder(int[][] field, int jump) {
        this.field = field;
        this.xLimit = field.length;
        this.yLimit = field[0].length;
        this.isVisited = new boolean[xLimit][yLimit];
        this.startColor = field[0][0];
        this.jump = jump;
    }

    public String getResult() {
        if (isUnreachableCase()) return "DEAD";
        return calc();
    }

    private String calc() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == xLimit - 1 && curY == yLimit - 1) return "ALIVE";

            for (int dx = -jump; dx <= jump; dx++) {
                for (int dy = -jump; dy <= jump; dy++) {
                    int nx = curX + dx;
                    int ny = curY + dy;

                    if (isWithinField(nx, ny) && isSameColorTile(nx, ny) && isReachableTile(curX, curY, nx, ny) && !isVisited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                    }
                }
            }

        }

        return "DEAD";
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < xLimit && 0 <= y && y < yLimit;
    }

    private boolean isUnreachableCase() {
        int x = field.length;
        int y = field[0].length;

        return field[0][0] != field[x - 1][y - 1];
    }

    private boolean isSameColorTile(int x, int y) {
        return field[x][y] == startColor;
    }

    private boolean isReachableTile(int fromX, int fromY, int targetX, int targetY) {
        return (Math.abs(fromX - targetX) + Math.abs(fromY - targetY)) <= jump;
    }
}

