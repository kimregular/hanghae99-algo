package p10101;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int[] input = new int[3];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        return input;
    }
}

class Solution {

    public String solution(int[] input) {
        int angle1 = input[0];
        int angle2 = input[1];
        int angle3 = input[2];

        if(angle1 + angle2 + angle3 != 180) return "Error";
        if(angle1 == angle2 && angle2 == angle3) return "Equilateral";
        if(angle1 == angle2 || angle1 == angle3 || angle2 == angle3) return "Isosceles";
        return "Scalene";
    }
}