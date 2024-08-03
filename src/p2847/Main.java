package p2847;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] stages) {
        int result = 0;

        for (int i = stages.length - 1; i > 0; i--) {
            if (stages[i] <= stages[i - 1]) {
                int newDifficulty = stages[i] - 1;
                result += stages[i - 1] - newDifficulty;
                stages[i - 1] = newDifficulty;
            }
        }
        return result;
    }
}