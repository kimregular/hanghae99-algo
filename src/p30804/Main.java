package p30804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] readInput(BufferedReader br) throws IOException {
        br.readLine();
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public int solution(int[] fruits) {
        if (isAlreadyBelowTwoKinds(fruits)) return fruits.length;

        int len = fruits.length;
        int answer = 0;
        int[] memo = new int[10];
        int left = 0;
        int right = 0;
        int cnt = 0;

        while (right < len) {
            int nextFruit = fruits[right];
            if (memo[nextFruit] == 0) {
                cnt++;
            }
            memo[nextFruit]++;
            right++;

            if (cnt > 2) {
                while (cnt > 2) {
                    int deleteTarget = fruits[left];
                    memo[deleteTarget]--;
                    if (memo[deleteTarget] == 0) {
                        cnt--;
                    }
                    left++;
                }
            }

            answer = Math.max(answer, right - left);
        }
        return answer;
    }

    private boolean isAlreadyBelowTwoKinds(int[] fruits) {
        int[] memo = new int[10];
        int cnt = 0;
        for (int fruit : fruits) {
            if (memo[fruit] == 0) {
                cnt++;
                memo[fruit]++;
            }
            if (cnt > 2) return false;
        }
        return true;
    }
}

