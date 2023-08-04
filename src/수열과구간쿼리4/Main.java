package 수열과구간쿼리4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, queries)));

    }
}

class Solution {

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                if (i % query[2] == 0) {
                    arr[i]++;
                }
            }
        }

        return arr;
    }
}
