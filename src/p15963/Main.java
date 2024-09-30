package p15963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}

class Solution {

    public int solution(long[] input) {
        if(isValid(input)) return 1;
        return 0;
    }

    private boolean isValid(long[] input) {
        long tokenA = input[0];
        long tokenB = input[1];
        return tokenA == tokenB;
    }
}