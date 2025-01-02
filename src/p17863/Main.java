package p17863;

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

    private char[] readInput(BufferedReader br) throws IOException {
        return br.readLine().toCharArray();
    }
}

class Solution {

    public String solution(char[] target) {
        return valid(target) ? "YES" : "NO";
    }

    private boolean valid(char[] target) {
        for (int i = 0; i < 3; i++) {
            if(target[i] != '5') return false;
        }
        return true;
    }
}