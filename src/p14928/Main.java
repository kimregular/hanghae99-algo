package p14928;

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

    private static String readInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public long solution(String target) {
        long dividor = 20000303;
        long answer = 0;

        for (int i = 0; i < target.length(); i++) {
            answer = (answer * 10 + (target.charAt(i) - '0')) % dividor;
        }
        return answer;
    }
}