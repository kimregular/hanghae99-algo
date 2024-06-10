package p2579;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] stairs) {
        if (stairs.length == 1) {
            return stairs[0];
        } else if (stairs.length == 2) {
            return stairs[0] + stairs[1];
        } else {
            return getMaxScore(stairs);
        }
    }

    private int getMaxScore(int[] stairs) {
        int[] scoreBoard = new int[stairs.length];
        scoreBoard[0] = stairs[0];
        scoreBoard[1] = stairs[0] + stairs[1];
        scoreBoard[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < scoreBoard.length; i++) {
            int scoreCandidate1 = scoreBoard[i - 2] + stairs[i];
            int scoreCandidate2 = scoreBoard[i - 3] + stairs[i] + stairs[i - 1];

            scoreBoard[i] = Math.max(scoreCandidate1, scoreCandidate2);
        }

        return scoreBoard[scoreBoard.length - 1];
    }
}