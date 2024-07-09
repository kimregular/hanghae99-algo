package p1094;

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

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public int solution(int target) {
        int stick = 64;
        int result = 0;

        while (target > 0) {
            if (stick > target) {
                stick /= 2;
            } else {
                target -= stick;
                result++;
            }
        }
        return result;
    }
}