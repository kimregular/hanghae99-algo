package p11890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private static int[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] field = new int[len][len];

        for (int i = 0; i < field.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return field;
    }
}

class Solution {

    public long solution(int[][] field) {
        Calculator c = new Calculator(field);
        return c.getResult();
    }
}

class Calculator {

    private final int[][] field;
    private long[][] probility;

    public Calculator(int[][] field) {
        this.field = field;
        this.probility = new long[field.length][field[0].length];
        probility[0][0] = 1;
    }

    public long getResult() {
        calc();
        int len = probility.length - 1;
        return probility[len][len];
    }

    private void calc() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                int jump = field[i][j];

                if(jump == 0) break;

                if(i + jump < field.length) probility[i + jump][j] += probility[i][j];
                if(j + jump < field.length) probility[i][j + jump] += probility[i][j];
            }
        }
    }
}