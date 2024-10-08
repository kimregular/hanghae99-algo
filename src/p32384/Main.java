package p32384;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int repeat) {
        String target = "LoveisKoreaUniversity";
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            answer.append(target).append(" ");
        }
        return answer.toString();
    }
}