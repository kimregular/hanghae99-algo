package p164499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br ) throws  IOException {
        int len = Integer.parseInt(br.readLine());
        String[] words = new String[len];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }
        return words;
    }
}

class Solution {

    private final Set<String> set = new HashSet<>();

    public int solution(String[] words) {
        for (String word : words) {
            char[] orderedChars = word.toCharArray();
            Arrays.sort(orderedChars);
            set.add(Arrays.toString(orderedChars));
        }
        return set.size();
    }
}