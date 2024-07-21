package p11656;

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

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public String solution(String target) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(target.substring(i));
        }

        return getAnswer(result);
    }

    private String getAnswer(List<String> target) {
        target.sort(null);
        StringBuilder result = new StringBuilder();
        for(String s : target){
            result.append(s).append("\n");
        }
        return result.toString();
    }
}