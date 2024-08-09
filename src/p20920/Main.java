package p20920;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.threshold, ip.words));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int threshold = Integer.parseInt(tokens[1]);

        String[] words = new String[len];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }
        return new Input(threshold, words);
    }

    private static class Input {

        int threshold;
        String[] words;

        public Input(int threshold, String[] words) {
            this.threshold = threshold;
            this.words = words;
        }
    }
}

class Solution {

    StringBuilder result = new StringBuilder();

    public String solution(int threshold, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if(word.length() < threshold) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> book = new ArrayList<>(map.keySet());
        book.sort(new WordComparator(map));
        for (String word : book) {
            result.append(word).append("\n");
        }
        return result.toString();
    }
}

class WordComparator implements Comparator<String> {

    Map<String, Integer> frequency;

    public WordComparator(Map<String, Integer> frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compare(String word1, String word2) {
        // 1. 빈도수가 높은 단어를 앞에 배치
        int freqCompare = frequency.get(word2).compareTo(frequency.get(word1));
        if (freqCompare != 0) {
            return freqCompare;
        }

        // 2. 길이가 긴 단어를 앞에 배치
        int lengthCompare = Integer.compare(word2.length(), word1.length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }

        // 3. 알파벳 사전순으로 앞에 있는 단어를 앞에 배치
        return word1.compareTo(word2);
    }
}