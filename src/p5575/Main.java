package p5575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = 3;

            Solution s = new Solution();

            for (int i = 0; i < TEST_CASE; i++) {
                String[] timeTable = br.readLine().split(" ");
                s.solution(timeTable);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public void solution(String[] timeTable) {
        int[] goToWork = new int[3];
        int[] leaveWork = new int[3];

        for (int i = 0; i < 3; i++) {
            goToWork[i] = Integer.parseInt(timeTable[i]);
            leaveWork[i] = Integer.parseInt(timeTable[i + 3]);
        }

        int goTime = goToWork[0] * 3600 + goToWork[1] * 60 + goToWork[2];
        int leaveTime = leaveWork[0] * 3600 + leaveWork[1] * 60 + leaveWork[2];

        int workTime = leaveTime - goTime;

        int workHour = workTime / 3600;
        int workMinute = (workTime % 3600) / 60;
        int workSecond = (workTime % 3600) % 60;

        System.out.println(workHour + " " + workMinute + " " + workSecond);
    }

}
