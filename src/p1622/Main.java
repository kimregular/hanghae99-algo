package p1622;

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

    private static List<String> readInput(BufferedReader br) throws IOException {
        List<String> result = new ArrayList<>();

        while (true) {
            String str1 = br.readLine();
            if(str1 == null) break;
            String str2 = br.readLine();
            result.add(str1);
            result.add(str2);
        }
        return result;
    }
}

class Solution {

    public String solution(List<String> stringList) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < stringList.size(); i+= 2) {
            String target1 = stringList.get(i);
            String target2 = stringList.get(i + 1);
            answer.append(getCommonString(target1, target2)).append("\n");
        }
        return answer.toString();
    }

    private String getCommonString(String target1, String target2) {
        int[] charDist1 = getCharDist(target1);
        int[] charDist2 = getCharDist(target2);

        StringBuilder commonString = new StringBuilder();
        for (int i = 0; i < charDist1.length; i++) {
            for (int j = 0; j < Math.min(charDist1[i], charDist2[i]); j++) {
                commonString.append((char) ('a' + i));
            }
        }
        return commonString.toString();
    }

    private int[] getCharDist(String target) {
        int[] result = new int[26];
        for (char c : target.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }
}