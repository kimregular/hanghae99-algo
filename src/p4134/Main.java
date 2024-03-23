package p4134;

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

    private static long[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        long[] nums = new long[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        return nums;
    }
}

class Solution {

    public String solution(long[] nums) {
        return getAnswer(nums);
    }

    private String getAnswer(long[] nums) {
        StringBuilder answer = new StringBuilder();
        for (long num : nums) {
            answer.append(getNextPrime(num)).append("\n");
        }
        return answer.toString();
    }

    private long getNextPrime(long num) {
        if(num <= 2) return 2;

        long nextPrime = 0;

        while (true) {
            if (isPrime(num)) {
                nextPrime = num;
                break;
            }
            num++;
        }
        return nextPrime;
    }

    private boolean isPrime(long num) {
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
