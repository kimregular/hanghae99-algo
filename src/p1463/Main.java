package p1463;

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

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public int solution(int target) {
        int[] field = new int[target + 1];
        field[1] = 0;
        for (int i = 2; i < field.length; i++) {
            field[i] = field[i - 1] + 1;
            if(i % 2 == 0) field[i] = Math.min(field[i], field[i / 2] + 1);
            if(i % 3 == 0) field[i] = Math.min(field[i], field[i / 3] + 1);
        }
        return field[target];
    }
}