package p10709;

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

    private static String[][] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[][] input = new String[x][y];
        for (int i = 0; i < x; i++) {
            input[i] = br.readLine().split("");
        }
        return input;
    }
}

class Solution {

    public String solution(String[][] input) {
        Calculator c = new Calculator(input);
        return c.getAnswer();
    }

    class Calculator {

        String[][] weather;
        int[][] answer;

        public Calculator(String[][] weather) {
            this.weather = weather;
            this.answer = new int[weather.length][weather[0].length];
            for(int[] ints : this.answer) Arrays.fill(ints, -1);
        }

        public String getAnswer() {
            calc();
            StringBuilder result = new StringBuilder();
            for (int[] ints : this.answer) {
                for (int i : ints) {
                    result.append(i).append(" ");
                }
                result.append("\n");
            }
            return result.toString();
        }

        private void calc() {
            for (int i = 0; i < this.answer.length; i++) {
                for (int j = 0; j < this.answer[i].length; j++) {
                    if(this.weather[i][j].equals("c")) estimateCloudArrival(i, j);
                }
            }
        }

        private void estimateCloudArrival(int i, int j) {
            int time = 0;
            for(int start = j; start < this.answer[i].length; start++) this.answer[i][start] = time++;
        }
    }
}