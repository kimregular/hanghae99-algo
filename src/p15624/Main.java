package p15624;

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

    public long solution(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        long[] field = new long[target + 1];
        field[0] = 0;
        field[1] = 1;
        for (int i = 2; i < field.length; i++) {
            field[i] = (field[i - 2] + field[i - 1]) % 1_000_000_007;
        }
        return field[target];
    }
}