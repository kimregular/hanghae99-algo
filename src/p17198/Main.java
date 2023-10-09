package p17198;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[][] farm = new String[10][10];

            for (int i = 0; i < 10; i++) {
                String[] tokens = br.readLine().split("");
                farm[i] = Arrays.copyOf(tokens, farm[i].length);
            }

            PathFinder pf = new PathFinder(farm);
            System.out.println(pf.getNumOfCows());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    String[][] farm;
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};


    public PathFinder(String[][] farm) {
        this.farm = farm;
        this.isVisited = new boolean[farm.length][farm[0].length];
    }

    public int getNumOfCows() {
        int numOfCows = 0;
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[i].length; j++) {
                if ("B".equals(farm[i][j])) {
                    numOfCows = findPath(i, j);
                }
            }
        }

        return numOfCows;
    }

    private int findPath(int x, int y) {
        Queue<Cow> q = new LinkedList<>();
        isVisited[x][y] = true;
        q.offer(new Cow(x, y, 0));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Cow currentCow = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = currentCow.x + dx[j];
                    int ny = currentCow.y + dy[j];
                    int numOfCow = currentCow.num;

                    if (isWithinFarm(nx, ny)) {
                        if (farm[nx][ny].equals("L")) return numOfCow;

                        if (!"R".equals(farm[nx][ny]) && !isVisited[nx][ny]) {
                            isVisited[nx][ny] = true;
                            q.offer(new Cow(nx, ny, numOfCow + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean isWithinFarm(int x, int y) {
        return x >= 0 && x < farm.length && y >= 0 && y < farm[x].length;
    }
}

class Cow {
    int x;
    int y;
    int num;

    public Cow(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

