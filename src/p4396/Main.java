package p4396;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int len = Integer.parseInt(br.readLine());
            Solution s = new Solution();
            System.out.println(s.solution(getInput(br, len), getInput(br, len)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br, int len) throws IOException {
        String[][] board = new String[len][len];

        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().split("");
        }

        return board;
    }
}

class Solution {

    public String solution(String[][] board, String[][] input) {
        MineSearchPlayer msp = new MineSearchPlayer(board, input);
        return getAnswer(msp.getResult());
    }

    private String getAnswer(String[][] result) {
        StringBuilder answer = new StringBuilder();

        for (String[] row : result) {
            for (String i : row) {
                answer.append(i);
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    private class MineSearchPlayer {

        String[][] mineField;
        String[][] inputs;
        boolean[][] isVisited;
        int[][] result;
        String[][] processedField;

        boolean isAlreadyFail = false;

        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        public MineSearchPlayer(String[][] mineField, String[][] inputs) {
            this.mineField = mineField;
            this.inputs = inputs;
            this.isVisited = new boolean[mineField.length][mineField[0].length];
            this.result = new int[mineField.length][mineField[0].length];
            this.processedField = new String[mineField.length][mineField[0].length];
            for (String[] strings : this.processedField) {
                Arrays.fill(strings, ".");
            }
        }

        public String[][] getResult() {
            playMineSearch();
            return afterPlay();
        }

        private String[][] afterPlay() {
            for (int x = 0; x < this.result.length; x++) {
                for (int y = 0; y < this.result[x].length; y++) {
                    if (this.isVisited[x][y]) this.processedField[x][y] = String.valueOf(this.result[x][y]);
                }
            }

            if(this.isAlreadyFail) failProcess();

            return this.processedField;
        }

        private void playMineSearch() {
            for (int x = 0; x < this.inputs.length; x++) {
                for (int y = 0; y < this.inputs[x].length; y++) {
                    if("x".equals(this.inputs[x][y])){
                        search(x, y);
                    }
                }
            }
        }

        private void search(int x, int y) {
            this.isVisited[x][y] = true;
            if (isMineLocated(x, y) && !this.isAlreadyFail) {
                this.isAlreadyFail = true;
            }
            for (int[] direction : this.directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (isWithinMineField(nx, ny) && isMineLocated(nx, ny)) this.result[x][y]++;
            }
        }

        private boolean isWithinMineField(int x, int y) {
            return 0 <= x && x < this.inputs.length && 0 <= y && y < this.inputs[x].length;
        }

        private boolean isMineLocated(int x, int y) {
            return "*".equals(this.mineField[x][y]);
        }

        private void failProcess() {
            for (int x = 0; x < this.processedField.length; x++) {
                for (int y = 0; y < this.processedField[x].length; y++) {
                    if("*".equals(this.mineField[x][y])) this.processedField[x][y] = "*";
                }
            }
        }
    }
}


