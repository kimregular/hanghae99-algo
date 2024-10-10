package p8892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<String>> readInput(BufferedReader br) throws IOException {
        int testCases = Integer.parseInt(br.readLine());
        List<List<String>> result = new ArrayList<>();
        while(testCases --> 0) result.add(new ArrayList<>());

        for (int i = 0; i < result.size(); i++) {
            int len = Integer.parseInt(br.readLine());
            for (int j = 0; j < len; j++) {
                result.get(i).add(br.readLine());
            }
        }
        return result;
    }
}

class Solution {

    public String solution(List<List<String>> testCases) {
        StringBuilder answer = new StringBuilder();

        for (List<String> testCase : testCases) {
            answer.append(calc(testCase)).append("\n");
        }
        return answer.toString();
    }

    private String calc(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if(i == j) continue;
                String target = words.get(i) + words.get(j);
                if(isPalindrome(target)) return target;
            }
        }
        return "0";
    }

    private boolean isPalindrome(String target) {
        int len = target.length();

        for (int i = 0; i < len / 2; i++) {
            if(target.charAt(i) != target.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}