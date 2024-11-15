package p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        StringBuilder answer = new StringBuilder();
        Solution s = new Solution();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int cnt = 1;
            while (true) {
                int len = Integer.parseInt(br.readLine());
                if (len == 0) break;
                answer.append("Problem ").append(cnt++).append(": ").append(s.solution(readInput(br, len))).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(answer);
    }

    private int[][] readInput(BufferedReader br, int len) throws IOException {
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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
        int result = Integer.MAX_VALUE;
        PriorityQueue<Location> q = new PriorityQueue<>();
        q.offer(new Location(0, 0, map[0][0]));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();

            if (cur.x == height && cur.y == width) {
                result = Math.min(result, cur.cost);
            }

            for (int[] direction : DIRECTIONS) {
                int nx = cur.x + direction[0];
                int ny = cur.y + direction[1];

                if (isWithinMap(nx, ny) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new Location(nx, ny, cur.cost + map[nx][ny]));
                }
            }
        }
        return result;
    }

    private boolean isWithinMap(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[x].length;
    }

    private static class Location implements Comparable<Location> {

        private final int x;
        private final int y;
        private final int cost;

        public Location(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Location o) {
            return Integer.compare(cost, o.cost);
        }
    }
}