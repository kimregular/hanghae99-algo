package p15988;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            while (TEST_CASE-- > 0) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long getInput(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
}

class Solution {

    public long solution(long target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        if(target == 3) return 4;
        long[] field = new long[(int) (target + 1)];
        field[1] = 1L;
        field[2] = 2L;
        field[3] = 4L;
        for (int i = 4; i < field.length; i++) {
            field[i] = (field[i - 1] + field[i - 2] + field[i - 3]) % 1_000_000_009;
        }
        return field[(int) target];
    }
}