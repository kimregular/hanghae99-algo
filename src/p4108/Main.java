package p4108;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x == 0 && y == 0) {
                    break;
                }

                Solution s = new Solution();
                System.out.println(s.solution(getInput(x, y, br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(int x, int y, BufferedReader br) throws IOException {
        String[][] mineField = new String[x][y];

        for (int i = 0; i < x; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < y; j++) {
                mineField[i] = tokens;
            }
        }

        return mineField;
    }
}

class Solution {

    public String solution(String[][] mineField) {
        int[][] targetMineField = convertStringMapToIntMap(mineField);
        int[][] markedMineField = getMarkedMineField(targetMineField);
//        for (int[] ints : markedMineField) {
//            for (int i : ints) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
        return getAnswer(markedMineField);
    }

    private String getAnswer(int[][] markedMineField) {
        StringBuilder answer = new StringBuilder();

        for (int[] row : markedMineField) {
            for (int elem : row) {
                if(elem == -1) answer.append("*");
                else answer.append(elem);
            }
            answer.append("\n");
        }
        answer.setLength(answer.length() - 1);

        return answer.toString();
    }

    private int[][] getMarkedMineField(int[][] targetMineField) {
        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < targetMineField.length; i++) {
            for (int j = 0; j < targetMineField[i].length; j++) {
                if (targetMineField[i][j] == -1) {
                    for (int[] direction : directions) {
                        int nx = i + direction[0];
                        int ny = j + direction[1];

                        if(isWithinField(nx, ny, targetMineField)) targetMineField[nx][ny]++;
                    }
                }
            }
        }
        return targetMineField;
    }

    private boolean isWithinField(int x, int y, int[][] targetMineField) {
        return x >= 0 && x < targetMineField.length && y >= 0 && y < targetMineField[x].length && targetMineField[x][y] != -1;
    }

    private int[][] convertStringMapToIntMap(String[][] mineField) {
        int[][] convertedMineField = new int[mineField.length][mineField[0].length];
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[0].length; j++) {
                if(mineField[i][j].equals("*")) convertedMineField[i][j] = -1;
            }
        }
        return convertedMineField;
    }
}