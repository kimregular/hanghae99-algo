package p6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String[][][]> readInput(BufferedReader br) throws IOException {
        List<String[][][]> result = new ArrayList<>();

        int idx = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int floors = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(floors == 0 && x == 0 && y == 0) break;

            result.add(new String[floors][x][y]);
            for (int i = 0; i < floors; i++) {
                for (int j = 0; j < x; j++) {
                    result.get(idx)[i][j] = br.readLine().split("");
                }
                br.readLine();
            }
            idx++;
        }
        return result;
    }
}

class Solution {

    public String solution(List<String[][][]> testCases) {
        StringBuilder answer = new StringBuilder();
        for (String[][][] testCase : testCases) {
            Calculator c = new Calculator(testCase);
            answer.append(c.getResult()).append("\n");
        }
        return answer.toString();
    }
}

class Calculator {

    private static final int[][] DIRECTIONS = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};

    private final String[][][] map;
    private final boolean[][][] isVisited;
    private int[] startPoint;
    private int[] endPoint;
    private int time = 0;

    public Calculator(String[][][] map) {
        this.map = map;
        this.isVisited = new boolean[map.length][map[0].length][map[0][0].length];

        int floors = map.length;
        int x = map[0].length;
        int y = map[0][0].length;

        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if(map[i][j][k].equals("S")) startPoint = new int[]{i, j, k};
                    if(map[i][j][k].equals("E")) endPoint = new int[]{i, j, k};
                    if(startPoint != null && endPoint != null) return;
                }
            }
        }
    }

    public String getResult() {
        simulateEscape();
        if(isFail()) return "Trapped!";
        return "Escaped in " + time + " minute(s).";
    }

    private void simulateEscape() {
        Queue<Location> q = new ArrayDeque<>();
        Location startLocation = new Location(startPoint[0], startPoint[1], startPoint[2], 0);
        q.offer(startLocation);
        visit(startLocation);

        while (!q.isEmpty()) {
            Location cur = q.poll();

            if (cur.isTargetLocation(endPoint)) {
                this.time = cur.getTime();
                return;
            }

            for (int[] direction : DIRECTIONS) {
                int nfloor = cur.getFloor() + direction[0];
                int nx = cur.getX() + direction[1];
                int ny = cur.getY() + direction[2];

                if (isWithinBuilding(nfloor, nx, ny) && isReachable(nfloor, nx, ny) && !isVisited[nfloor][nx][ny]) {
                    Location nextLocation = new Location(nfloor, nx, ny, cur.getTime() + 1);
                    visit(nextLocation);
                    q.offer(nextLocation);
                }
            }
        }
    }

    private void visit(Location location) {
        int floor = location.getFloor();
        int x = location.getX();
        int y = location.getY();
        isVisited[floor][x][y] = true;
    }

    private boolean isFail() {
        return time == 0;
    }

    private boolean isWithinBuilding(int z, int x, int y) {
        return 0 <= z && z < map.length && 0 <= x && x < map[z].length && 0 <= y && y < map[z][x].length;
    }

    private boolean isReachable(int z, int x, int y) {
        return map[z][x][y].equals(".") || map[z][x][y].equals("E");
    }

    private static class Location {

        private final int floor;
        private final int x;
        private final int y;
        private final int time;

        public Location(int floor, int x, int y, int time) {
            this.floor = floor;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean isTargetLocation(int[] targetPoint) {
            return floor == targetPoint[0] && x == targetPoint[1] && y == targetPoint[2];
        }

        public int getFloor() {
            return floor;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }
    }
}