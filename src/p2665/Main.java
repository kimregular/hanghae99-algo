package p2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

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
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            result[i] = br.readLine().chars().map(c -> c - '0').toArray();
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
        int height = map.length - 1;
        int width = map[0].length - 1;

        PriorityQueue<Location> q = new PriorityQueue<>();
        int demolish = map[0][0] == 1 ? 0 : 1;
        q.offer(new Location(0, 0, demolish));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();

            if(cur.x == height && cur.y == width) return cur.demolish;

            for (int[] direction : DIRECTIONS) {
                int nx = cur.x + direction[0];
                int ny = cur.y + direction[1];

                if (isWithinMap(nx, ny) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new Location(nx, ny, map[nx][ny] == 1 ? cur.demolish : cur.demolish + 1));
                }
            }
        }
        return -1;
    }

    private boolean isWithinMap(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[x].length;
    }

    private static class Location implements Comparable<Location> {

        private final int x;
        private final int y;
        private final int demolish;

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