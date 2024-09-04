package p1748;

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

    public int solution(int target) {
        int cnt = 1;
        int temp = 0;
        int length = 10;

        for (int i = 1; i <= target; i++) {
            if (i == length) {
                cnt++;
                length *= 10;
            }
            temp += cnt;
        }
        return temp;
    }
}