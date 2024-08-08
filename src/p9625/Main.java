package p9625;

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

    public String solution(int target) {
        int[][] field = new int[target + 1][2];
        field[0] = new int[]{0, 0};
        field[1] = new int[]{0, 1};
        if(target == 1) return field[1][0] + " " + field[1][1];

        field[2] = new int[]{1, 1};
        if(target == 2) return field[2][0] + " " + field[2][1];

        for (int i = 3; i < field.length; i++) {
            field[i][0] = field[i - 1][0] + field[i - 2][0];
            field[i][1] = field[i - 1][1] + field[i - 2][1];
        }
        return field[target][0] + " " + field[target][1];
    }
}