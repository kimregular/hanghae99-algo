package p10093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            long[] ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip[0], ip[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getInput(BufferedReader br) throws IOException {
        long[] input = new long[2];
        String[] tokens = br.readLine().split(" ");
        input[0] = Long.parseLong(tokens[0]);
        input[1] = Long.parseLong(tokens[1]);
        return input;
    }
}

class Solution {

    public String solution(long num1, long num2) {

        if(num1 == num2) return "0";

        long start = Math.min(num1, num2);
        long end = Math.max(num1, num2);

        StringBuilder answer = new StringBuilder();

        answer.append(end - start - 1).append("\n");
        for (long i = start + 1; i < end; i++) {
            answer.append(i).append(" ");
        }
        return answer.toString();
    }

}