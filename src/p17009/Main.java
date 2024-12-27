package p17009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br), readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] readInput(BufferedReader br) throws IOException {
        int[] scores = new int[3];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        return scores;
    }
}

class Solution {

    public String solution(int[] A, int[] B) {
        return getTotalScore(A) > getTotalScore(B) ? "A" : getTotalScore(A) == getTotalScore(B) ? "T" : "B";
    }

    private int getTotalScore(int[] scores) {
        int result = 0;
        result += scores[0] * 3;
        result += scores[1] * 2;
        result += scores[2] * 1;
        return result;
    }
}