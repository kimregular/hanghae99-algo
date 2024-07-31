package p25178;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] words = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(words[0], words[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        br.readLine();
        String[] result = new String[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public String solution(String word1, String word2) {
        if(isValid(word1, word2)) return "YES";
        return "NO";
    }

    private boolean isValid(String word1, String word2) {
        return isAnagram(word1, word2) && isFirstAndLastSame(word1, word2) && isConsonantSame(word1, word2);
    }

    private boolean isAnagram(String word1, String word2) {
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();

        Arrays.sort(word1CharArray);
        Arrays.sort(word2CharArray);

        return Arrays.equals(word1CharArray, word2CharArray);
    }

    private boolean isFirstAndLastSame(String word1, String word2) {
        return isFirstSame(word1, word2) && isLastSame(word1, word2);
    }

    private boolean isFirstSame(String word1, String word2) {
        return word1.charAt(0) == word2.charAt(0);
    }

    private boolean isLastSame(String word1, String word2) {
        return word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1);
    }

    private boolean isConsonantSame(String word1, String word2) {
        return vowelFilter(word1).equals(vowelFilter(word2));
    }

    private String vowelFilter(String word) {
        StringBuilder wordWithoutVowel = new StringBuilder();

        for (char c : word.toCharArray()) {
            if(isVowel(c)) continue;
            wordWithoutVowel.append(c);
        }
        return wordWithoutVowel.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}