package p1769;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }
}

class Solution {

    public String solution(String target) {
        int numOfReduce = 0;
        while (target.length() > 1) {
            target = String.valueOf(reduce(target));
            numOfReduce++;
        }
        return getAnswer(numOfReduce, isMulple3(Integer.parseInt(target)));
    }

    private String getAnswer(int numOfReduce, String isMultiple3) {
        StringBuilder answer = new StringBuilder();
        return answer.append(numOfReduce).append("\n").append(isMultiple3).toString();
    }

    private int reduce(String target) {
        int result = 0;
        for (char c : target.toCharArray()) {
            result += c - '0';
        }
        return result;
    }

    private String isMulple3(int target) {
        if(target == 3 || target == 6 || target == 9) return "YES";
        return "NO";
    }
}