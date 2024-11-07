package p11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] times) {
        Arrays.sort(times);

        int cumulatedTime = 0;
        int answer = 0;
        for (int time : times) {
            cumulatedTime += time;
            answer += cumulatedTime;
        }
        return answer;
    }
}