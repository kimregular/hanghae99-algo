package p22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

    private int[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public int solution(int[] infos) {
        int fatigue = infos[0];
        int productivity = infos[1];
        int rest = infos[2];
        int limit = infos[3];

        int answer = 0;
        int curFatigue = 0;

        int day = 24;
        while (day-- > 0) {
            if (curFatigue + fatigue <= limit) {
                curFatigue += fatigue;
                answer += productivity;
            } else {
                curFatigue -= rest;
                if (curFatigue < 0) {
                    curFatigue = 0;
                }
            }
        }
        return answer;
    }
}