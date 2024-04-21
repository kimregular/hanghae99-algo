package p1312;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);
        int c = Integer.parseInt(tokens[2]);
        return new int[]{a, b, c};
    }
}

class Solution {

    public int solution(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        int result = 0;
        for (int i = 0; i < c; i++) {
            a = (a % b) * 10;
            result = a / b;
        }
        return result;
    }
}
