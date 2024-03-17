package p14729;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        double[] ip = new double[len];

        for (int i = 0; i < len; i++) {
            ip[i] = Double.parseDouble(br.readLine());
        }
        return ip;
    }
}

class Solution {

    public String solution(double[] scores) {
        Arrays.sort(scores);
        return getAnswer(scores);
    }

    private String getAnswer(double[] scores) {
        StringBuilder answer = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##0.000");
        for (int i = 0; i < 7; i++) {
            answer.append(df.format(scores[i])).append("\n");
        }
        return answer.toString();
    }
}
