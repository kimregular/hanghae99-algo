package p1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int width = Integer.parseInt(tokens[0]);
        int height = Integer.parseInt(tokens[1]);

        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            result[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] map) {
        Calculator c = new Calculator(map);
        return c.getResult();
    }
}

class Calculator {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    private final int[][] map;
    private final boolean[][] isVisited;

    public Calculator(int[][] map) {
        this.map = map;
        this.isVisited = new boolean[map.length][map[0].length];
    }

    public int getResult() {
        return calc();
    }

    private int calc() {
        int height = map.length - 1;
        int width = map[0].length - 1;

        int result = Integer.MAX_VALUE;

        PriorityQueue<Location> q = new PriorityQueue<>();
        q.offer(new Location(0, 0, 0));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();

            if (cur.x == height && cur.y == width) {
                result = Math.min(result, cur.demolish);
            }

            for (int[] direction : DIRECTIONS) {
                int nx = cur.x + direction[0];
                int ny = cur.y + direction[1];

                if (isWithinMap(nx, ny) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new Location(nx, ny, map[nx][ny] == 1 ? cur.demolish + 1 : cur.demolish));
                }
            }
        }
        return result;
    }

    private boolean isWithinMap(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[x].length;
    }

    private static class Location implements Comparable<Location> {
        final int x;
        final int y;
        final int demolish;

        public Location(int x, int y, int demolish) {
            this.x = x;
            this.y = y;
            this.demolish = demolish;
        }

        @Override
        public int compareTo(Location o) {
            return Integer.compare(demolish, o.demolish);
        }
    }
}