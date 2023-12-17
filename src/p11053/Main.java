package p11053;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());

            int[] arr = new int[len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution(arr);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] arr;

    public Solution(int[] arr) {
        this.arr = arr;
    }

    public int solution() {
        return findLIS(getDP());
    }

    private static int findLIS(int[] dp) {
        int result = -1;
        for (int max : dp) {
            if (result < max) {
                result = max;
            }
        }
        return result;
    }

    private int[] getDP() {
        int[] dp = new int[this.arr.length];

        for (int i = 0; i < this.arr.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(this.arr[j] < this.arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
        }
        return dp;
    }
}