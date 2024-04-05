package p1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader bufferedReader) throws IOException {
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[][] board = new String[x][y];

        for (int i = 0; i < board.length; i++) {
            board[i] = bufferedReader.readLine().split("");
        }

        return board;
    }
}

class Solution {

    public int solution(String[][] board) {
        Calculator c = new Calculator(board);
        return c.getResult();
    }

    private class Calculator{

        String[][] board;
        boolean[][] isOccupied;
        int numOfNoGuardianRows = 0;
        int numOfNoGuardianColumns = 0;

        public Calculator(String[][] board) {
            this.board = board;
            this.isOccupied = new boolean[board.length][board[0].length];
        }

        public int getResult() {
            search();
            return Math.max(this.numOfNoGuardianColumns, this.numOfNoGuardianRows);
        }

        private void search() {
            for (int i = 0; i < this.board.length; i++) {
                int numOfGuardianRows = 0;
                for (int j = 0; j < this.board[i].length; j++) {
                    if(this.board[i][j].equals("X")) numOfGuardianRows++;
                }
                if(numOfGuardianRows == 0) this.numOfNoGuardianRows++;
            }

            for (int i = 0; i < this.board[0].length; i++) {
                int numOfGuardianColumns = 0;
                for (int j = 0; j < this.board.length; j++) {
                    if(this.board[j][i].equals("X")) numOfGuardianColumns++;
                }
                if(numOfGuardianColumns == 0) this.numOfNoGuardianColumns++;
            }
        }

    }
}
