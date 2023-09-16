package p2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET = Integer.parseInt(br.readLine());

            Solution s = new Solution(TARGET);
            System.out.println(s.getNumberOfCase());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int TARGET;
    int[] arr;

    public Solution(int TARGET) {
        this.TARGET = TARGET;
        this.arr = new int[TARGET];

        for (int i = 0; i < TARGET; i++) {
            arr[i] = i+1;
        }
    }

    public int getNumberOfCase() {
        int answer = 0;
        int lp = 0;
        int rp = 0;

        int sum = 0;

        while (true) {
            if (lp == arr.length) {
                break;
            }

            if (sum < TARGET) {
                sum += arr[rp++];
            }

            if (sum == TARGET) {
                answer++;
                sum -= arr[lp++];
            }

            if (sum > TARGET) {
                sum -= arr[lp++];
            }
        }

        return answer;
    }
}
