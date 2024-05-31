package p31614;

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
        int hour = Integer.parseInt(br.readLine());
        int minute = Integer.parseInt(br.readLine());
        return new int[]{hour, minute};
    }
}

class Solution {

    public int solution(int[] input) {
        int hour = input[0];
        int minute = input[1];
        return hour * 60 + minute;
    }
}