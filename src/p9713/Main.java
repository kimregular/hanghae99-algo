package p9713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public String solution(int[] nums) {
        StringBuilder answer = new StringBuilder();
        for (int num : nums) {
            answer.append(calc(num)).append("\n");
        }
        return answer.toString();
    }

    private int calc(int limit) {
        int result = 0;
        for (int i = 1; i < limit + 1; i++) {
            if(i % 2 != 0) result += i;
        }
        return result;
    }
}