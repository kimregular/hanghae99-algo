package p2563;

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
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] squares) {
        Calculator c = new Calculator(squares);
        return c.getResult();
    }

    private static class Calculator{

        boolean[][] board = new boolean[101][101];
        int result = 0;

        public Calculator(int[][] squares) {
            for (int[] square : squares) {
                paint(square);
            }
        }

        private void paint(int[] square) {
            int startX = square[1];
            int startY = square[0];

            for (int x = startX; x < startX + 10; x++) {
                for (int y = startY; y < startY + 10; y++) {
                    board[x][y] = true;
                }
            }
        }

        public int getResult() {
            calc();
            return result;
        }

        private void calc() {
            for (boolean[] row : board) {
                for (boolean isTrue : row) {
                    if(isTrue) result++;
                }
            }
        }
    }
}
