package p15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public String solution(String target) {
        return target.toUpperCase();
    }
}