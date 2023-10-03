package p2589;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            String[][] maps = new String[height][width];

            for (int i = 0; i < height; i++) {
                String[] tokens = br.readLine().split("");
                for (int j = 0; j < width; j++) {
                    maps[i] = Arrays.copyOf(tokens, width);
                }
            }

            TreasureFinder tf = new TreasureFinder(maps);
            tf.findTreasure();
            System.out.println(tf.answer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class TreasureFinder {

    String[][] maps;

    boolean[][] isVisited;
    int[][] dis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int answer = 0;

    public TreasureFinder(String[][] maps) {
        this.maps = maps;
    }

    public void findTreasure() {

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if ("L".equals(maps[i][j])) {
                    explorePath(i, j);
                }
            }
        }
    }

    private void explorePath(int x, int y) {
        this.isVisited = new boolean[maps.length][maps[0].length];
        this.dis = new int[maps.length][maps[0].length];

        isVisited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {

                Point tmp = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if(isWithinMaps(nx, ny) && "L".equals(maps[nx][ny]) && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                        q.offer(new Point(nx, ny));

                        answer = Math.max(answer, dis[nx][ny]);
                    }
                }
            }
        }

    }

    private boolean isWithinMaps(int x, int y) {
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
