package p1309;

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
        if(target == 1) return 3;
        long[] zoo = new long[target + 1];
        zoo[0] = 1;
        zoo[1] = 3;
        for (int i = 2; i < zoo.length; i++) {
            zoo[i] = (2 * zoo[i - 1] + zoo[i - 2]) % 9901;
        }
        return zoo[target];
    }
}