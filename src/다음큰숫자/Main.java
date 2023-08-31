package 다음큰숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());

            Solution s = new Solution();
            System.out.println(s.solution(num));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int n) {
        String num = Integer.toBinaryString(n);
        int ones = 0;
        for (char c : num.toCharArray()) {
            if ('1' == c) {
                ones++;
            }
        }

        int answer = n+1;
        while (true) {
            String nextNum = Integer.toBinaryString(answer);
            if (isSameOnes(ones, nextNum)) {
                return Integer.parseInt(nextNum, 2);
            }

            answer++;
        }
    }

    private boolean isSameOnes(int ones, String num) {
        int cnt = 0;
        for (char c : num.toCharArray()) {
            if ('1' == c) {
                cnt++;
            }
        }

        return ones == cnt;
    }
}