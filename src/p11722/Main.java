package p11722;

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
        int[] dp = new int[this.arr.length];

        for (int i = 0; i < this.arr.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(this.arr[i] < this.arr[j] && dp[j] > dp[i] - 1) dp[i]++;
            }
        }

        int result = 0;
        for (int d : dp) {
            if(result < d) result = d;
        }
//        System.out.println(Arrays.toString(dp));
        return result;
    }
}