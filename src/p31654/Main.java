package p31654;

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

    public String solution(int[] nums) {
        if(isCorrect(nums[0], nums[1], nums[2])) return "correct!";
        return "wrong!";
    }

    private boolean isCorrect(int a, int b, int c) {
        return a + b == c;
    }
}