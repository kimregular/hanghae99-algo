package p9295;

import java.io.*;

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
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            result[i][0] = a;
            result[i][1] = b;
        }

        return result;
    }
}

class Solution {

    public String solution(int[][] testCases) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases.length; i++) {
            result.append("Case ").append(i + 1).append(": ").append(testCases[i][0] + testCases[i][1]).append("\n");
        }

        return result.toString();
    }
}