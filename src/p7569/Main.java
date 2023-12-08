package p7569;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            int[][][] plate = new int[z][x][y];

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    for (int k = 0; k < y; k++) {
                        plate[i][j][k] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            Tomato t = new Tomato(plate);
            System.out.println(t.getDays());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Tomato {

    int[][][] plate;
    boolean[][][] isGood;
    int[][] directions = {{0, 0, 1}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};

    public Tomato(int[][][] plate) {
        this.plate = plate;
        this.isGood = new boolean[plate.length][plate[0].length][plate[0][0].length];
    }

    public int getDays() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < this.plate.length; i++) {
            for (int j = 0; j < this.plate[0].length; j++) {
                for (int k = 0; k < this.plate[0][0].length; k++) {
                    if (plate[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        this.isGood[i][j][k] = true;
                    }
                }
            }
        }
        int result = BFS(q);


        if (!isAllGood()) return -1;
        return result;
    }

    private int BFS(Queue<int[]> q) {
        int days = -1;

        while (!q.isEmpty()) {
            int len = q.size();
            days++;

            for (int i = 0; i < len; i++) {
                int[] currentTomato = q.poll();

                for (int[] direction : directions) {
                    int nz = currentTomato[0] + direction[0];
                    int nx = currentTomato[1] + direction[1];
                    int ny = currentTomato[2] + direction[2];

                    if (isWithinPlate(nz, nx, ny)) {
                        if (!this.isGood[nz][nx][ny]) {
                            if (this.plate[nz][nx][ny] == 0) {
                                this.isGood[nz][nx][ny] = true;
                                this.plate[nz][nx][ny] = days;
                                q.offer(new int[]{nz, nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return days;
    }

    private boolean isWithinPlate(int z, int x, int y) {
        return z >= 0 && z < this.plate.length && x >= 0 && x < this.plate[z].length && y >= 0 && y < this.plate[z][x].length;
    }

    private boolean isAllGood() {
        for (int i = 0; i < this.plate.length; i++) {
            for (int j = 0; j < this.plate[0].length; j++) {
                for (int k = 0; k < this.plate[0][0].length; k++) {
                    if (plate[i][j][k] == 0 && !this.isGood[i][j][k]) return false;
                }
            }
        }
        return true;
    }
}
