package p10953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        int[][] input = new int[len][2];
        for (int i = 0; i < len; i++) {
            String[] tokens = br.readLine().split(",");
            input[i][0] = Integer.parseInt(tokens[0]);
            input[i][1] = Integer.parseInt(tokens[1]);
        }
        return input;
    }
}


class Solution {

    public String solution(int[][] input) {
        StringBuilder answer = new StringBuilder();
        for (int[] nums : input) {
            answer.append(nums[0] + nums[1]).append("\n");
        }

        return answer.toString();
    }
}