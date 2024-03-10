package p25206;

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

    private static String[] getInput(BufferedReader br) throws IOException {
        return br.lines().limit(20).toArray(String[]::new);
    }
}

class Solution {

    public double solution(String[] notes) {
        HashMap<String, Double> gradeGpaMap = new HashMap<>() {{
            put("A+", 4.5);
            put("A0", 4.0);
            put("B+", 3.5);
            put("B0", 3.0);
            put("C+", 2.5);
            put("C0", 2.0);
            put("D+", 1.5);
            put("D0", 1.0);
            put("F", 0.0);
        }};

        double totalCredit = 0;
        double rawScore = 0;
        for (String note : notes) {
            String[] noteInfo = note.split(" ");
            double credit = Double.parseDouble(noteInfo[1]);
            String score = noteInfo[2];

            if(score.equals("P")) continue;

            totalCredit += credit;
            rawScore += credit * gradeGpaMap.get(score);
        }

        return rawScore / totalCredit;
    }
}