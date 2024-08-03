package p13417;

import java.io.*;
import java.util.*;

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

    private static String[] getInput(BufferedReader br) throws IOException {
        br.readLine();
        return br.readLine().split(" ");
    }
}

class Solution {

    public String solution(String[] cards) {
        Deque<String> dq = new ArrayDeque<>();

        for (String card : cards) {
            if (dq.isEmpty()) {
                dq.addFirst(card);
            } else {
                if (dq.peekFirst().compareTo(card) < 0) {
                    dq.addLast(card);
                } else {
                    dq.addFirst(card);
                }
            }
        }
        return getString(dq);
    }

    private String getString(Deque<String> dq) {
        StringBuilder result = new StringBuilder();
        for (String s : dq) {
            result.append(s);
        }
        return result.toString();
    }
}