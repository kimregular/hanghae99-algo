package p21736;

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
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        String[][] result = new String[x][y];

        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine().split("");
        }
        return result;
    }
}

class Solution {

    public String solution(String[][] field) {
        Calculator c = new Calculator(field);
        return c.getResult();
    }
}

class Calculator {

    private final String[][] field;
    private final boolean[][] isVisited;
    private final Queue<int[]> q;
    private int result;

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public Calculator(String[][] field) {
        this.field = field;
        this.isVisited = new boolean[field.length][field[0].length];
        this.q = new ArrayDeque<>();
        this.result = 0;
    }

    public String getResult() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if("I".equals(field[i][j])){
                    isVisited[i][j] = true;
                    q.offer(new int[]{i, j});
                    return explore();
                }
            }
        }
        return "TT"; // 여기까지 도달하지 않음
    }

    private String explore() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(field[cur[0]][cur[1]].equals("P")) result++;

            for (int[] direction : directions) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isWithinField(nx, ny) && !"X".equals(field[nx][ny]) && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return result == 0 ? "TT" : String.valueOf(result);
    }

    private boolean isWithinField(int x, int y) {
        return 0 <= x && x < field.length && 0 <= y && y < field[x].length;
    }
}