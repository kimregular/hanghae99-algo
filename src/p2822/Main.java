package p2822;

import java.io.*;
import java.util.*;

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
        int[] scores = new int[8];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        return scores;
    }
}

class Solution {

    public String solution(int[] scores) {
        ScoreWithIndex[] si = getIndexedScores(scores);
        return getBestScores(si);
    }

    private String getBestScores(ScoreWithIndex[] si) {
        StringBuilder answer = new StringBuilder();
        int bestScore = 0;
        int[] index = new int[5];
        for (int i = 0; i < 5; i++) {
            bestScore += si[i].score;
            index[i] = si[i].index;
        }

        Arrays.sort(index);
        answer.append(bestScore).append("\n");
        for (int i : index) {
            answer.append(i).append(" ");
        }
        return answer.toString();
    }

    private ScoreWithIndex[] getIndexedScores(int[] scores) {
        ScoreWithIndex[] si = new ScoreWithIndex[scores.length];

        for (int i = 0; i < scores.length; i++) {
            si[i] = new ScoreWithIndex(scores[i], i+1);
        }
        Arrays.sort(si);
        return si;
    }

    class ScoreWithIndex implements Comparable<ScoreWithIndex> {
        int score;
        int index;

        public ScoreWithIndex(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(ScoreWithIndex other) {
            return other.score - this.score;
        }
    }
}