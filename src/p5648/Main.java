package p5648;

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

    private static long[] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());

        long[] nums = new long[len];
        int idx = 0;

        while (st.hasMoreTokens()) {
            nums[idx++] = Long.parseLong(st.nextToken());
        }

        while (idx < nums.length) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                nums[idx++] = Long.parseLong(st.nextToken());
            }
        }
        return nums;
    }
}

class Solution {

    public String solution(long[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = reverseNum(nums[i]);
        }
        Arrays.sort(nums);
        return getAnswer(nums);
    }

    private long reverseNum(long num) {
        long result = 0;
        while (num > 0) {
            result *= 10;
            result += num%10;
            num /= 10;
        }
        return result;
    }

    private String getAnswer(long[] nums) {
        StringBuilder answer = new StringBuilder();
        for (long num : nums) {
            answer.append(num).append("\n");
        }
        return answer.toString();
    }
}
