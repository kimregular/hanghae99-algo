package p2669;

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
        int[][] result = new int[4][4];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] squares) {
        boolean[][] board = new boolean[101][101];

        for (int[] square : squares) {
            int x1 = square[0];
            int y1 = square[1];
            int x2 = square[2];
            int y2 = square[3];

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
