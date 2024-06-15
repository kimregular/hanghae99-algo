package p30224;

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

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String input) {
        int targetNum = Integer.parseInt(input);
        if (input.contains("7")) {
            if (targetNum % 7 == 0) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (targetNum % 7 == 0) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}