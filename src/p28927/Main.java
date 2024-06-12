package p28927;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public String solution(int[] max, int[] mel) {
        int maxScore = 0;
        int melScore = 0;
        for (int i = 0; i < max.length; i++) {
            if (i == 0) {
                maxScore += max[i] * 3;
                melScore += mel[i] * 3;
            } else if (i == 1) {
                maxScore += max[i] * 20;
                melScore += mel[i] * 20;
            } else {
                maxScore += max[i] * 120;
                melScore += mel[i] * 120;
            }
        }

        if(maxScore > melScore){
            return "Max";
        } else if (maxScore == melScore) {
            return "Draw";
        } else {
            return "Mel";
        }
    }
}