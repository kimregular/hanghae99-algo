package p4963DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());

                if (w == 0 && h == 0) {
                    break;
                }

                int[][] land = new int[h][w];
                for (int i = 0; i < h; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    for (int j = 0; j < w; j++) {
                        land[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                Solution solution = new Solution(land);
                System.out.println(solution.calculateIslands());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[][] land;
    int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    public Solution(int[][] land) {
        this.land = land;
    }

    public int calculateIslands() {
        int islandCount = 0;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    islandCount++;
                    exploreIsland(i, j);
                }
            }
        }

        return islandCount;
    }

    private void exploreIsland(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isWithinBounds(nx, ny) && land[nx][ny] == 1) {
                land[nx][ny] = 0;
                exploreIsland(nx, ny);
            }
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < land.length && y >= 0 && y < land[x].length;
    }
}
