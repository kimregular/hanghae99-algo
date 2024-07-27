package p3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        String[] dimensions = br.readLine().split(" ");
        int x = Integer.parseInt(dimensions[0]);
        int y = Integer.parseInt(dimensions[1]);
        String[][] field = new String[x][y];

        for (int i = 0; i < field.length; i++) {
            field[i] = br.readLine().split("");
        }

        return field;
    }
}

class Solution {

    public String solution(String[][] field) {
        SeekAndHide sh = new SeekAndHide(field);
        return sh.getResult();
    }
}

class SeekAndHide {

    String[][] field;
    boolean[][] isChecked;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int sheepSurvived = 0;
    int wolvesSurvived = 0;

    public SeekAndHide(String[][] field) {
        this.field = field;
        this.isChecked = new boolean[field.length][field[0].length];
    }

    public String getResult() {
        explore();
        return sheepSurvived + " " + wolvesSurvived;
    }

    private void explore() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (!field[i][j].equals("#") && !isChecked[i][j]) {
                    isChecked[i][j] = true;
                    seekAndHide(i, j);
                }
            }
        }
    }

    private void seekAndHide(int x, int y) {
        int wolves = 0;
        int sheep = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if(field[curX][curY].equals("v")) wolves++;
            else if(field[curX][curY].equals("k")) sheep++;

            for (int[] direction : directions) {
                int nx = curX + direction[0];
                int ny = curY + direction[1];

                if (isWithinField(nx, ny) && !isChecked[nx][ny] && !field[nx][ny].equals("#")) {
                    isChecked[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if(sheep > wolves) sheepSurvived += sheep;
        else wolvesSurvived += wolves;
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < field.length && 0 <= y && y < field[x].length;
    }
}