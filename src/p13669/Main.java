package p13669;

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
        if(target == 0) return 1;
        if(target == 1) return 1;

        long[] field = new long[target + 1];
        field[0] = 1L;
        field[1] = 1L;


        for (int i = 2; i < field.length; i++) {
            for (int j = 0; j < i; j++) {
                field[i] += field[j] * field[i - 1 - j];
            }
        }
        return field[target];
    }
}