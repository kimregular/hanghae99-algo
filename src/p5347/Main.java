package p5347;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        long a = Integer.parseInt(tokens[0]);
        long b = Integer.parseInt(tokens[1]);
        return new long[]{a, b};
    }
}

class Solution {

    public long solution(long[] numbers) {
        long bigger = Math.max(numbers[0], numbers[1]);
        long smaller = Math.min(numbers[0], numbers[1]);
        return getLCM(bigger, smaller);
    }

    private long getLCM(long a, long b) {
        return (a * b) / getGCD(a, b);
    }

    private long getGCD(long a, long b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}
