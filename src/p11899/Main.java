package p11899;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String target) {
        int answer = 0;
        int openCount = 0;

        for (char c : target.toCharArray()) {
            if (c == ')') {
                if (openCount == 0) {
                    answer++;
                } else {
                    openCount--;
                }
            } else {
                openCount++;
            }
        }

        answer += openCount;

        return answer;
    }
}