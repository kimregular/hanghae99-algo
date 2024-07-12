package p2740;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                result[i][j] = Integer.parseInt(line[j]);
            }
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] matrix1, int[][] matrix2) {
        Calculator c = new Calculator(matrix1, matrix2);
        return c.getAnswer();
    }

    private class Calculator {

        int[][] matrix1;
        int[][] matrix2;
        int[][] result;

        public Calculator(int[][] matrix1, int[][] matrix2) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.result = new int[matrix1.length][matrix2[0].length];
        }

        public String getAnswer() {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = calc(i, j);
                }
            }
            return getResult();
        }

        private int calc(int x, int y) {
            int[] xMatrix = matrix1[x];
            int[] yMatrix = getYMatrix(y);

            int result = 0;
            for (int i = 0; i < xMatrix.length; i++) {
                result += xMatrix[i] * yMatrix[i];
            }
            return result;
        }

        private int[] getYMatrix(int y) {
            int[] result = new int[matrix2.length];

            for (int i = 0; i < matrix2.length; i++) {
                result[i] = matrix2[i][y];
            }
            return result;
        }

        private String getResult() {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    answer.append(result[i][j]).append(" ");
                }
                answer.append("\n");
            }
            return answer.toString();
        }
    }
}