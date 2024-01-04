package p1100;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[][] board = new String[8][8];

            for (int i = 0; i < 8; i++) {
                String[] tokens = br.readLine().split("");
                board[i] = tokens;
            }

            Solution s = new Solution(board);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    String[][] board;

    public Solution(String[][] board) {
        this.board = board;
    }

    public int solution() {
        int numOfTargets = 0;

        boolean isWhite = true;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (isWhite && this.board[i][j].equals("F")) {
                    numOfTargets++;
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }

        return numOfTargets;
    }
}