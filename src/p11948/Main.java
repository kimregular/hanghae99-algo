package p11948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = 6;
            int[] scores = new int[TEST_CASE];
            for (int i = 0; i < TEST_CASE; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }

            Solution s = new Solution();
            System.out.println(s.solution(scores));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int[] scores) {
        int answer = 0;

        int[] subsOf4 = Arrays.copyOfRange(scores, 0, 4);
        int[] subsOf2 = Arrays.copyOfRange(scores, 4, scores.length);


        Arrays.sort(subsOf4);
        Arrays.sort(subsOf2);

        for (int i = 0; i < 3; i++) {
            answer += subsOf4[subsOf4.length - i - 1];
        }

        answer += subsOf2[1];

        return answer;
    }
}
