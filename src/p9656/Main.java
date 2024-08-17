package p9656;

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

/*
* SK and CY
* SK first
*
* each can take 1 or 3 stones
*
* n = 1 -> CY
* 2 -> SK
* 3 -> CY
* 4 -> SK
* 5 -> CY
* 6 -> SK
*
* */
    public String solution(int num) {
        return num % 2 == 0 ? "SK" : "CY";
    }
}