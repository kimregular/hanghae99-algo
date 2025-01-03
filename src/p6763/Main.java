package p6763;

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
            System.out.println(s.solution(readInput(br), readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int standard, int target) {
        return isExceeding(standard, target) ? giveFine(standard,
                                                        target) : "Congratulations, you are within the speed limit!";
    }

    private boolean isExceeding(int standard, int target) {
        return standard - target < 0;
    }

    private String giveFine(int standard, int target) {
        String result = "You are speeding and your fine is $";
        int fine = 0;
        int exceepding = Math.abs(standard - target);

        if (exceepding <= 20) {
            fine = 100;
        } else if (exceepding <= 30) {
            fine = 270;
        } else {
            fine = 500;
        }

        return result + fine + ".";
    }
}