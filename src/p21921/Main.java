package p21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int LEN = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());

            int[] arr = new int[LEN];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < LEN; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution(period, arr);
            int[] result = s.solution();

            if (result[0] == 0) {
                System.out.println("SAD");
            } else {
                for (int i : result) {
                    System.out.println(i);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int period;
    int[] arr;

    public Solution(int period, int[] arr) {
        this.period = period;
        this.arr = arr;
    }

    public int[] solution() {
        int cnt = 1;
        int max = 0;
        int answer = 0;

        for (int i = 0; i < period; i++) {
            max += arr[i];
        }
        answer = max;

        for (int i = period; i < arr.length; i++) {
            max -= arr[i - period];
            max += arr[i];

            if (answer < max) {
                cnt = 1;
                answer = max;
            } else if (answer == max) {
                cnt++;
            }
        }

        return new int[]{answer, cnt};
    }
}