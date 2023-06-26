package 특별한이차원배열1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int n = 3;
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.solution(n)));

    }
}


class Solution {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int ONE = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < answer[j].length; j++) {
                if (i == j) {
                    answer[i][j] = ONE;
                    break;
                }
            }
        }
        return answer;
    }
}