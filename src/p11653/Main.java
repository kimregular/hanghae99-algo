package p11653;

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

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int target) {
        StringBuilder answer = new StringBuilder();
        if(isPrime(target)) return String.valueOf(target);
        for (int i = 2; i <= target; i++) {
            while (target % i == 0) {
                answer.append(i).append("\n");
                target /= i;
            }
        }

        if(target != 1) answer.append(target);

        return answer.toString();
    }

    private boolean isPrime(int target) {
        if(target < 2) return false;
        if(target == 2) return true;
        for (int i = 2; i < Math.sqrt(target) + 1; i++) {
            if(target % i == 0) return false;
        }
        return true;
    }
}