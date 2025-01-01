package p26068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = br.readLine();
        }
        return result;
    }
}

class Solution {

    public int solution(String[] targets) {
        int result = 0;
        for (String target : targets) {
            if(valid(target)) result++;
        }
        return result;
    }

    private boolean valid(String target) {
        String[] temp = target.split("-");
        return Integer.parseInt(temp[1]) <= 90;
    }
}