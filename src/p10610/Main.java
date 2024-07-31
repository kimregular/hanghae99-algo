package p10610;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public String solution(String target) {
        if(!hasZero(target) || !multipleOfThree(target)) return "-1";

        String[] digits = String.valueOf(target).split("");
        Arrays.sort(digits, Comparator.reverseOrder());
        return String.join("", digits);
    }

    private boolean hasZero(String num) {
        for (char c : num.toCharArray()) {
            if(c == '0') return true;
        }
        return false;
    }

    private boolean multipleOfThree(String num) {
        int sumOfDigits = getSumOfDigits(num);
        return sumOfDigits % 3 == 0;
    }

    private int getSumOfDigits(String num) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }

        if(sum > 9) sum = getSumOfDigits(sum);
        return sum;
    }

    private int getSumOfDigits(int num) {
        if(num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if(sum > 9) sum = getSumOfDigits(sum);
        return sum;
    }
}