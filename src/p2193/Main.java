package p2193;

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
        if(target <= 2) return 1;
        long[] result = new long[target + 1];
        result[1] = 1;
        result[2] = 1;
        for(int i = 3; i < result.length; i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[target];
    }
}