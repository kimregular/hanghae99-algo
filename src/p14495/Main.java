package p14495;

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

    public long solution(int target) {
        if(target <= 3) return 1;
        return getField(target)[target];
    }

    private long[] getField(int target) {
        long[] field = new long[target + 1];
        field[1] = 1;
        field[2] = 1;
        field[3] = 1;
        for (int i = 4; i < field.length; i++) {
            field[i] = field[i - 1] + field[i - 3];
        }
        return field;
    }
}