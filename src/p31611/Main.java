package p31611;

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

    public int solution(int num) {
        if(isTuesday(num)) return 1;
        return 0;
    }

    private boolean isTuesday(int num) {
        return num % 7 == 2;
    }
}