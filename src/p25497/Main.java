package p25497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char[] readInput(BufferedReader br) throws IOException {
        br.readLine();
        return br.readLine().toCharArray();
    }
}

class Solution {

    public int solution(char[] skills) {
        int answer = 0;
        Deque<Character> stkL = new ArrayDeque<>();
        Deque<Character> stkS = new ArrayDeque<>();
        for (char skill : skills) {
            if (skill == 'L') {
                stkL.add(skill);
            } else if (skill == 'S') {
                stkS.add(skill);
            } else if (skill == 'R') {
                if (stkL.isEmpty()) {
                    return answer;
                } else {
                    stkL.pollLast();
                    answer++;
                }
            } else if (skill == 'K') {
                if (stkS.isEmpty()) {
                    return answer;
                } else {
                    stkS.pollLast();
                    answer++;
                }
            } else {
                answer++;
            }
        }
        return answer;
    }
}