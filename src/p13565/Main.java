package p13565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        String[] dimension = br.readLine().split(" ");
        int x = Integer.parseInt(dimension[0]);
        int y = Integer.parseInt(dimension[1]);
        int[][] field = new int[x][y];

        for (int i = 0; i < field.length; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return field;
    }
}

class Solution {

    public String solution(int[][] fabric) {
        Calculator c = new Calculator(fabric);
        return c.getResult();
    }
}

class Calculator {

    int[][] fabric;
    boolean[][] isChecked;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean isPercolate = false;

    public Calculator(int[][] fabric) {
        this.fabric = fabric;
        this.isChecked = new boolean[fabric.length][fabric[0].length];
    }

    public String getResult() {
        for (int i = 0; i < fabric[0].length; i++) {
            if (fabric[0][i] == 0) {
                DFS(0, i);
            }
            if(isPercolate) return "YES";
        }
        return "NO";
    }

    private void DFS(int x, int y) {
        isChecked[x][y] = true;

        if (x == fabric.length - 1 && fabric[x][y] == 0) {
            isPercolate = true;
            return;
        }

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (isWithinFabric(nx, ny) && fabric[nx][ny] == 0 && !isChecked[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }

    private boolean isWithinFabric(int x, int y) {
        return 0 <= x && x < fabric.length && 0 <= y && y < fabric[x].length;
    }
}