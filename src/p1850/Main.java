package p1850;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}

class Solution {

    StringBuilder answer = new StringBuilder();

    public String solution(long[] nums) {
        long bigger = Math.max(nums[0], nums[1]);
        long smaller = Math.min(nums[0], nums[1]);
        long gcd = getGCD(bigger, smaller);
        for (int i = 1; i <= gcd; i++) {
            answer.append("1");
        }
        return answer.toString();
    }

    private long getGCD(long bigger, long smaller) {
        if (smaller == 0) return bigger;
        return getGCD(smaller, bigger % smaller);
    }
}