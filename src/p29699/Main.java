package p29699;

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

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine()) - 1;
    }
}

class Solution {

    private static final String target = "WelcomeToSMUPC";

    public char solution(int idx) {
        int len = target.length();
        if (idx < len) {
            return target.charAt(idx);
        } else {
            idx %= len;
            return target.charAt(idx);
        }
    }
}