package p2468BFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[][] maps = new int[n][n];

            ArrayList<Integer> rainLevels = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    int token = Integer.parseInt(st.nextToken());
                    if (!rainLevels.contains(token)) rainLevels.add(token);
                    maps[i][j] = token;
                }
            }
            Collections.sort(rainLevels);

            SafeAreaFinder saf = new SafeAreaFinder(rainLevels, maps);
            System.out.println(saf.getMaxNumOfSafeArea());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class SafeAreaFinder {

    ArrayList<Integer> rainLevels;
    int[][] maps;
    int[][] calculatedMaps;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int maxNumOfSafeAreas = 0;

    public SafeAreaFinder(ArrayList<Integer> rainLevels, int[][] maps) {
        this.rainLevels = rainLevels;
        this.maps = maps;
    }

    public int getMaxNumOfSafeArea() {
        for (int level : rainLevels) {
            this.calculatedMaps = createCaculatedMaps(level);
            maxNumOfSafeAreas = Math.max(maxNumOfSafeAreas, getNumOfSafeAreas());
        }

        return maxNumOfSafeAreas == 0 ? 1 : maxNumOfSafeAreas;
        // 아무곳도 잠기지 않는다면 안전지대는 1개!
    }

    private int[][] createCaculatedMaps(int level) {
        int[][] result = new int[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] <= level) result[i][j] = 0;
                else result[i][j] = maps[i][j];
            }
        }
        return result;
    }

    private int getNumOfSafeAreas() {
        int numOfSafeArea = 0;

        for (int i = 0; i < calculatedMaps.length; i++) {
            for (int j = 0; j < calculatedMaps[i].length; j++) {
                if (calculatedMaps[i][j] != 0) {
                    numOfSafeArea++;
                    calculatedMaps[i][j] = 0;
                    exploreSafeArea(i, j);
                }
            }
        }

        return numOfSafeArea;
    }

    private void exploreSafeArea(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (isWithinCalculatedMaps(nx, ny) && calculatedMaps[nx][ny] != 0) {
                        calculatedMaps[nx][ny] = 0;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private boolean isWithinCalculatedMaps(int x, int y) {
        return x >= 0 && x < maps.length && y >= 0 && y < maps[x].length;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}