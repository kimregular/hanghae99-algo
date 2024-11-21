package p18409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readInput(BufferedReader br) throws IOException {
        br.readLine();
        return br.readLine();
    }
}

class Solution {

    private static final char[] vowels = {'a', 'i', 'u', 'e', 'o'};

    public int solution(String target){
        int answer = 0;

        for (char c : target.toCharArray()) {
            if(isVowel(c)) answer++;
        }
        return answer;
    }

    private boolean isVowel(char c){
        for (char vowel : vowels) {
            if(c == vowel) return true;
        }
        return false;
    }
}