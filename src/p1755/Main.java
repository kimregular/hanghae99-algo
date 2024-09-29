package p1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int start = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);
        return new int[]{start, end};
    }
}

class Solution {

    public String solution(int[] input) {
        String[] numberStrings = getNumberStrings(getStringNumbers(input));
        return getAnswer(numberStrings);
    }

    private String getAnswer(String[] numberStrings) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for (String numberString : numberStrings) {
            answer.append(numberString).append(" ");
            idx++;
            if (idx == 10) {
                answer.append("\n");
                idx = 0;
            }
        }
        return answer.toString();
    }

    private String[] getNumberStrings(String[] stringNumbers) {
        String[] result = new String[stringNumbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = convertToNumberString(stringNumbers[i]);
        }
        return result;
    }

    private String convertToNumberString(String target) {
        StringBuilder result = new StringBuilder();
        for (String number : target.split(" ")) {
            result.append(matchToNumber(number));
        }
        return result.toString();
    }

    private String matchToNumber(String target) {
        return switch (target) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> "0";
        };
    }

    private String[] getStringNumbers(int[] input) {
        int start = input[0];
        int end = input[1];
        String[] result = new String[end + 1 - start];
        for (int i = start; i <= end; i++) {
            result[i - start] = getString(i);
        }
        Arrays.sort(result);
        return result;
    }

    private String getString(int number) {
        StringBuilder result = new StringBuilder();

        String stringNumber = String.valueOf(number);
        for (char c : stringNumber.toCharArray()) {
            result.append(matchToString(c)).append(" ");
        }
        return result.toString();
    }

    private String matchToString(char c) {
        return switch (c) {
            case '1' -> "one";
            case '2' -> "two";
            case '3' -> "three";
            case '4' -> "four";
            case '5' -> "five";
            case '6' -> "six";
            case '7' -> "seven";
            case '8' -> "eight";
            case '9' -> "nine";
            default -> "zero";
        };
    }
}