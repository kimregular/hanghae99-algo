package p18111;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfBlocks, ip.board));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] ip = br.readLine().split(" ");
        int x = Integer.parseInt(ip[0]);
        int y = Integer.parseInt(ip[1]);
        int numOfBlocks = Integer.parseInt(ip[2]);

        int[][] board = new int[x][y];
        for (int i = 0; i < x; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return new Input(numOfBlocks, board);
    }

    private static class Input {

        private int numOfBlocks;
        private int[][] board;

        public Input(int numOfBlocks, int[][] board) {
            this.numOfBlocks = numOfBlocks;
            this.board = board;
        }
    }
}

class Solution {

    public String solution(int numOfBlocks, int[][] board) {
        Calculator c = new Calculator(board, numOfBlocks);
        return c.getResult();
    }

    private class Calculator {

        private int[][] board;
        private int numOfBlocks;
        private int minHeight = 0;
        private int maxHeight = 0;
        private StringBuilder result = new StringBuilder();

        private final int TILE_DIG_TIME = 2;

        public Calculator(int[][] board, int numOfBlocks) {
            this.board = board;
            this.numOfBlocks = numOfBlocks;
            setMinMaxHeight();
        }

        public String getResult() {
            calc();
            return result.toString();
        }

        private void calc() {

            int totalTimeResult = Integer.MAX_VALUE;
            int heightResult = 0;

            for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {

                int consumedTime = 0;
                int blocks = numOfBlocks;

                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[x].length; y++) {

                        int targetTile = board[x][y];

                        if (targetTile > targetHeight) {
                            // 타일이 목표값보다 높을 경우
                            consumedTime += (targetTile - targetHeight) * TILE_DIG_TIME;
                            blocks += targetTile - targetHeight;
                        } else {
                            // 타일이 목표값보다 낮을 경우
                            consumedTime += targetHeight - targetTile;
                            blocks -= Math.abs(targetTile - targetHeight);
                        }
                    }
                }
                if(blocks < 0) break;
                if (totalTimeResult >= consumedTime) {
                    totalTimeResult = consumedTime;
                    heightResult = Math.max(heightResult,targetHeight);
                }
            }
            result.append(totalTimeResult).append(" ").append(heightResult);
        }

        private void setMinMaxHeight() {
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    minValue = Math.min(minValue, board[i][j]);
                    maxValue = Math.max(maxValue, board[i][j]);
                }
            }

            this.minHeight = minValue;
            this.maxHeight = maxValue;
        }
    }
}