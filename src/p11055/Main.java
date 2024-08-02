package p11055;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = nums.clone();

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}