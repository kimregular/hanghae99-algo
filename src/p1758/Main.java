package p1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public long solution(int[] tips) {
        long answer = 0L;
        Arrays.sort(tips);

        int len = tips.length;
        for (int i = 0; i < len; i++) {
            if(tips[len - i - 1] - i > 0) answer += tips[len - i - 1] - i;
        }
        return answer;
    }
}
