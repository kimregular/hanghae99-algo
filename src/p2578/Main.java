package p2578;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[][] board = getInput(br);
            int[][] ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(board, ip));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        int[][] input = new int[5][5];

        for (int i = 0; i < input.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return input;
    }
}

class Solution {

    public int solution(int[][] board, int[][] input) {
        Calculator c = new Calculator(board, input);
        return c.getCnt();
    }

    class Calculator {

        int[][] board;
        boolean[][] check;
        int[][] input;
        int cnt = 0;

        public Calculator(int[][] board, int[][] input) {
            this.board = board;
            this.check = new boolean[board.length][board[0].length];
            this.input = input;
        }

        public int getCnt() {
            for (int i = 0; i < this.input.length; i++) {
                for (int j = 0; j < this.input[i].length; j++) {
                    check(this.input[i][j]);
                    if(isCompleted()) return this.cnt;
                }
            }
            return -1;
        }

        private void check(int num) {
            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board[i].length; j++) {
                    if (this.board[i][j] == num) {
                        this.check[i][j] = true;
                        this.cnt++;
                    }
                }
            }
        }

        private boolean isCompleted() {
            int crossedLines = 0;
            for (int i = 0; i < this.board.length; i++) {
                int completeCnt1 = 0;
                int completeCnt2 = 0;
                for (int j = 0; j < this.board[i].length; j++) {
                    if(this.check[i][j]) completeCnt1++;
                    if(this.check[j][i]) completeCnt2++;
                }
                if(completeCnt1 == 5) crossedLines++;
                if(completeCnt2 == 5) crossedLines++;
            }

            int completeCnt3 = 0;
            int completeCnt4 = 0;
            for (int i = 0; i < this.board.length; i++) {
                if(this.check[i][i]) completeCnt3++;
                if(this.check[i][this.board[i].length - 1 - i]) completeCnt4++;
            }
            if(completeCnt3 == 5) crossedLines++;
            if(completeCnt4 == 5) crossedLines++;

            return crossedLines >= 3;
        }
    }

}
