package p11123;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int testCase = 0; testCase < TEST_CASE; testCase++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                String[][] field = new String[n][m];

                for (int i = 0; i < n; i++) {
                    String[] tokens = br.readLine().split("");
                    field[i] = Arrays.copyOf(tokens, m);
                }

                GroupFinder gf = new GroupFinder(field);
                System.out.println(gf.getNumOfGroups());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GroupFinder {

    String[][] field;
    boolean[][] isChecked;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public GroupFinder(String[][] field) {
        this.field = field;
        this.isChecked = new boolean[field.length][field[0].length];
    }

    public int getNumOfGroups() {
        int numOfGroups = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("#") && !isChecked[i][j]) {
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
        isChecked[x][y] = true;

        while (!q.isEmpty()) {
            int len = q.size();


            for (int i = 0; i < len; i++) {
                int[] currentPoint = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = currentPoint[0] + dx[j];
                    int ny = currentPoint[1] + dy[j];

                    if (isWithinField(nx, ny) && field[nx][ny].equals("#") && !isChecked[nx][ny]) {
                        isChecked[nx][ny] = true;
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