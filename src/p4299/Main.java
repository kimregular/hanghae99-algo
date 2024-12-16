package p4299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

    private int[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public String solution(int[] scores) {
        int a = scores[0];
        int b = scores[1];

        if (a < b) return "-1";

        for (int A = 0; A <= a; A++) {
            int B = a - A;
            if (A - B == b) {
                return A + " " + B;
            }
        }
        return "-1";
    }
}
