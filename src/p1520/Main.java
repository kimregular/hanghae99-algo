package p1520;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Map map = new Map(x, y);
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < y; j++) {
                    map.setValue(i, j, Integer.parseInt(st.nextToken()));
                }
            }

            PathFinder pf = new PathFinder(map);
            System.out.println(pf.findPath(0, 0));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    Map map;
    int[][] isVisited;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public PathFinder(Map map) {
        this.map = map;
        this.isVisited = new int[this.map.getX()][this.map.getY()];
        for (int[] ints : this.isVisited) {
            Arrays.fill(ints, -1);
        }
    }

    public int findPath(int x, int y) {
        if (x == this.map.getX() - 1 && y == this.map.getY() - 1) {
            return 1;
        }
        if (this.isVisited[x][y] != -1) {
            return this.isVisited[x][y];
        } else {
            this.isVisited[x][y] = 0;
            for (int i=0; i< this.directions.length; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (!isWithinMap(nx, ny)) {
                    continue;
                }

                if (this.map.getValue(x, y) > this.map.getValue(nx, ny)) {
                    this.isVisited[x][y] += findPath(nx, ny);
                }
            }

        }

        return this.isVisited[x][y];
    }

    private boolean isWithinMap(int x, int y) {
        return x >= 0 && x < this.map.getX() && y >= 0 && y < this.map.getY();
    }
}

class Map {

    int x;
    int y;
    int[][] map;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        this.map = new int[x][y];
    }

    public void setValue(int x, int y, int value) {
        this.map[x][y] = value;
    }

    public int getValue(int x, int y) {
        return this.map[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMap() {
        return map;
    }
}