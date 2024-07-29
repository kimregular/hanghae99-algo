package p9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        int[] targets = new int[len];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }
        return targets;
    }
}

class Solution {

    StringBuilder result = new StringBuilder();

    public String solution(int[] targets) {
        for (int target : targets) {
            result.append(calc(target)).append("\n");
        }
        return result.toString();
    }

    private int calc(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        if(target == 3) return 4;
        int[] field = new int[target + 1];
        field[1] = 1;
        field[2] = 2;
        field[3] = 4;
        for (int i = 4; i < field.length; i++) {
            field[i] = field[i - 3] + field[i - 2] + field[i - 1];
        }
        return field[target];
    }
}