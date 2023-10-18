package p5958;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            String[][] space = new String[n][n];

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split("");
                space[i] = Arrays.copyOf(tokens, n);
            }

            SpaceExplorer se = new SpaceExplorer(space);
            System.out.println(se.getNumOfAsteroids());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class SpaceExplorer {

    String[][] space;
    boolean[][] isVisited;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public SpaceExplorer(String[][] space) {
        this.space = space;
        this.isVisited = new boolean[space.length][space[0].length];
    }

    public int getNumOfAsteroids() {
        int numOfAsteroids = 0;

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                if ("*".equals(space[i][j]) && !isVisited[i][j]) {
                    numOfAsteroids++;
                    exploreSpace(i, j);
                }
            }
        }
        return numOfAsteroids;
    }

    private void exploreSpace(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] currentPosition = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = currentPosition[0] + dx[j];
                    int ny = currentPosition[1] + dy[j];

                    if (isWithinSpace(nx, ny) && "*".equals(space[nx][ny]) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private boolean isWithinSpace(int x, int y) {
        return x >= 0 && x < space.length && y >= 0 && y < space[x].length;
    }
}
