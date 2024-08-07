package p9655;

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

    public String solution(int num) {
        if(isSKVictorious(num)) return "SK";
        return "CY";
    }

    private boolean isSKVictorious(int num) {
        return num % 2 != 0;
    }
}