package 수열과구간쿼리3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3}, {1, 2}, {1, 4}};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, queries)));
    }
}

class Solution {

    public int[] solution(int[] arr, int[][] queries) {

        for (int[] query : queries) {
            int left = arr[query[0]];
            int right = arr[query[1]];

            arr[query[0]] = right;
            arr[query[1]] = left;
        }
        return arr;
    }


}
