package p1149;

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

        int[][] result = new int[len][3];

        for (int i = 0; i < result.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int red = Integer.parseInt(tokens[0]);
            int green = Integer.parseInt(tokens[1]);
            int blue = Integer.parseInt(tokens[2]);

            result[i][0] = red;
            result[i][1] = green;
            result[i][2] = blue;
        }

        return result;
    }
}

class Solution {

    public int solution(int[][] prices) {

        for (int i = 1; i < prices.length; i++) {
            prices[i][0] += Math.min(prices[i - 1][1], prices[i - 1][2]);
            prices[i][1] += Math.min(prices[i - 1][0], prices[i - 1][2]);
            prices[i][2] += Math.min(prices[i - 1][0], prices[i - 1][1]);
        }

        return Math.min(prices[prices.length - 1][0], Math.min(prices[prices.length - 1][1], prices[prices.length - 1][2]));
    }
}