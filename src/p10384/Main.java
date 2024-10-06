package p10384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public String solution(String[] testCases) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < testCases.length; i++) {
            answer.append("Case " + (i + 1) + ": ").append(validate(testCases[i])).append("\n");
        }
        return answer.toString();
    }

    private String validate(String testCase) {
        int[] alphabets = new int[26];
        for (String str : testCase.split(" ")) {
            for (char c : str.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    alphabets[c - 'a']++;
                } else if ('A' <= c && c <= 'Z') {
                    alphabets[c - 'A']++;
                }
            }
        }
        int charWithOne = 0;
        int charWithTwo = 0;
        int charWithThree = 0;

        for (int alphabet : alphabets) {
            if (alphabet == 1) {
                charWithOne++;
            } else if (alphabet == 2) {
                charWithOne++;
                charWithTwo++;
            } else if (alphabet >= 3) {
                charWithOne++;
                charWithTwo++;
                charWithThree++;
            }
        }

        if (charWithThree >= 26) return "Triple pangram!!!";
        else if (charWithTwo >= 26) return "Double pangram!!";
        else if (charWithOne >= 26) return "Pangram!";
        return "Not a pangram";
    }
}