package 특별한이차원배열2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        Solution s = new Solution();
        System.out.println(s.solution(arr));

    }
}

class Solution {

    public int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }

        return 1;

    }
}
