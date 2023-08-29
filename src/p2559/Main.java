package p2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int LEN = Integer.parseInt(st.nextToken());
            int DAY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[LEN];
            for (int i = 0; i < LEN; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution();
            System.out.println(s.solution(DAY, arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int DAY, int[] arr) {
        int answer = Integer.MIN_VALUE;

        int window = 0;
        for (int i = 0; i < DAY; i++) {
            window += arr[i];
        }
        answer = Math.max(answer, window);

        for (int i = DAY; i < arr.length; i++) {
            window += arr[i];
            window -= arr[i - DAY];
            answer = Math.max(answer, window);
        }

        return answer;
    }
}
