package p14562;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int myScore = Integer.parseInt(st.nextToken());
                int oppositScore = Integer.parseInt(st.nextToken());

                ScoreFinder sf = new ScoreFinder(new Score(myScore, oppositScore, 0));
                answer.append(sf.getNumOfKicks()).append("\n");
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ScoreFinder {

    Score score;
//    boolean[] isKicked = new boolean[50000];

    public ScoreFinder(Score score) {
        this.score = score;
    }

    public int getNumOfKicks() {
        int minNumOfKicks = Integer.MAX_VALUE;
        Queue<Score> q = new LinkedList<>();
        q.offer(score);
//        isKicked[score.myScore] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Score currentScore = q.poll();

                if(currentScore.myScore == currentScore.oppositScore){
                    minNumOfKicks = Math.min(minNumOfKicks, currentScore.numOfKicks);
                }

                int kickOne = currentScore.myScore * 2;
                int kickTwo = currentScore.myScore + 1;

                if (isPossible(kickOne, currentScore.oppositScore + 3)) {
                    q.offer(new Score(kickOne, currentScore.oppositScore + 3, currentScore.numOfKicks + 1));
//                    isKicked[kickOne] = true;
                }
                if (isPossible(kickTwo, currentScore.oppositScore)) {
                    q.offer(new Score(kickTwo, currentScore.oppositScore, currentScore.numOfKicks + 1));
//                    isKicked[kickTwo] = true;
                }

            }
        }
        return minNumOfKicks;
    }

    private boolean isPossible(int kick, int oppositScore) {
//        !(isKicked[kick]) &&
        return kick <= oppositScore;
    }
}

class Score {

    int myScore;
    int oppositScore;

    int numOfKicks;

    public Score(int myScore, int oppositScore, int numOfKicks) {
        this.myScore = myScore;
        this.oppositScore = oppositScore;
        this.numOfKicks = numOfKicks;
    }
}