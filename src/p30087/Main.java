package p30087;

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
        int len = Integer.parseInt(br.readLine());

        String[] input = new String[len];
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }
        return input;
    }
}

class Solution {

    public String solution(String[] seminas) {
        Map<String, String> places = Map.of(
                "Algorithm", "204",
                "DataAnalysis", "207",
                "ArtificialIntelligence", "302",
                "CyberSecurity", "B101",
                "Network", "303",
                "Startup", "501",
                "TestStrategy", "105"
        );

        StringBuilder answer = new StringBuilder();
        for (String semina : seminas) {
            answer.append(places.get(semina)).append("\n");
        }
        return answer.toString();
    }
}