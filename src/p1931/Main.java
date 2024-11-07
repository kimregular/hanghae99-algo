package p1931;

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

    private int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][2];

        for (int i = 0; i < len; i++) {
            String[] tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            result[i][0] = start;
            result[i][1] = end;
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] schedules) {
        Arrays.sort(schedules, (a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return a[1] - b[1];
        });

        int answer = 0;
        int lastMeetingEnd = 0;
        for (int[] schedule : schedules) {
            if (schedule[0] >= lastMeetingEnd) {
                lastMeetingEnd = schedule[1];
                answer++;
            }
        }
        return answer;
    }
}