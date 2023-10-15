package p4677;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                if (n == 0 && m == 0) {
                    break;
                }

                String[][] field = new String[n][m];
                for (int i = 0; i < n; i++) {
                    String[] tokens = br.readLine().split("");
                    field[i] = Arrays.copyOf(tokens, m);
                }

                OilDepositFinder odf = new OilDepositFinder(field);
                System.out.println(odf.getNumOfOilDeposits());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class OilDepositFinder {

    String[][] field;
    boolean[][] isVisited;

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public OilDepositFinder(String[][] field) {
        this.field = field;
        this.isVisited = new boolean[field.length][field[0].length];
    }

    public int getNumOfOilDeposits() {
        int numOfOilDeposits = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if ("@".equals(field[i][j]) && !isVisited[i][j]) {
                    numOfOilDeposits++;
                    exploreOilDeposit(i, j);
                }
            }
        }
        return numOfOilDeposits;
    }

    private void exploreOilDeposit(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        isVisited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] currentPosition = q.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = currentPosition[0] + dx[j];
                    int ny = currentPosition[1] + dy[j];

                    if (isWithinField(nx, ny) && !isVisited[nx][ny] && "@".equals(field[nx][ny])) {
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