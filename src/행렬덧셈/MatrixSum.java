package 행렬덧셈;

import java.util.Arrays;

public class MatrixSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr1 = {{1}, {2}};
        int[][] arr2 = {{3}, {4}};
        System.out.println(s.solution(arr1, arr2));

    }

}
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        if (arr1.length == 0) {
            return answer;
        }

        answer = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
