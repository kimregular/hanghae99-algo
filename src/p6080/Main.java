package p6080;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] field = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            GroupFinder gf = new GroupFinder(field);
            System.out.println(gf.getNumOfGroups());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GroupFinder {

    int[][] field;
    boolean[][] isVisited;

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public GroupFinder(int[][] field) {
        this.field = field;
        this.isVisited = new boolean[field.length][field[0].length];
    }

    public int getNumOfGroups() {
        int numOfGroups = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != 0 && !isVisited[i][j]) {
                    explore(i, j);
                    numOfGroups++;
                }
            }
        }

        return numOfGroups;
    }

    private void explore(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] currentPoint = q.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = currentPoint[0] + dx[j];
                    int ny = currentPoint[1] + dy[j];

                    if (isWithinField(nx, ny) && field[nx][ny] != 0 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private boolean isWithinField(int x, int y) {
        return x >= 0 && x < field.length && y >= 0 && y < field[x].length;
    }
}