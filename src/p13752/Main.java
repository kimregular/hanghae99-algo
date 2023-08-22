package p13752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            Solution s = new Solution();

            for (int i = 0; i < TEST_CASE; i++) {
                int n = Integer.parseInt(br.readLine());
                System.out.println(s.solution(n));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("=");
        }

        return sb.toString();
    }
}
