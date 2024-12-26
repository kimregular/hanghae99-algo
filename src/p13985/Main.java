package p13985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public String solution(String target) {
        return isValid(parseTargetToNumArray(target)) ? "YES" : "NO";
    }

    private int[] parseTargetToNumArray(String target) {
        String[] temp = target.split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[2]);
        int c = Integer.parseInt(temp[4]);
        return new int[]{a, b, c};
    }

    private boolean isValid(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        return a + b == c;
    }
}