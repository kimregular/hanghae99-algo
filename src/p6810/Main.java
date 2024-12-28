package p6810;

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
            System.out.printf("The 1-3-sum is %d", s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] readInput(BufferedReader br) throws IOException {
        int[] result = new int[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) result += input[i] * 1;
            else result += input[i] * 3;
        }
        return 91 + result;
    }
}