package p1388;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            String[][] floor = new String[x][y];

            for (int i = 0; i < x; i++) {
                String[] tokens = br.readLine().split("");
                floor[i] = Arrays.copyOf(tokens, y);
            }

            FloorChecker fc = new FloorChecker(floor);
            System.out.println(fc.checkFloor());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class FloorChecker {

    String[][] floor;
    boolean[][] isChecked;

    int[] d = {1, -1};

    public FloorChecker(String[][] floor) {
        this.floor = floor;
        this.isChecked = new boolean[floor.length][floor[0].length];
    }

    public int checkFloor() {
        int answer = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                if (!isChecked[i][j]) {
                    answer++;
                    explore(i, j, floor[i][j]);
                }
            }
        }
        return answer;
    }

    private void explore(int x, int y, String str) {
        isChecked[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;

            if (str.equals("|")) {
                nx += d[i];
            } else {
                ny += d[i];
            }

            if (isWithinFloor(nx, ny)) {
                if (!isChecked[nx][ny]) {
                    if (floor[nx][ny].equals(str)) {
                        explore(nx, ny, str);
                    }
                }
            }
        }
    }

    private boolean isWithinFloor(int x, int y) {
        return x >= 0 && x < floor.length && y >= 0 && y < floor[x].length;
    }
}
