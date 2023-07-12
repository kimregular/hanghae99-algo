package 수열과구간쿼리1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, queries)));

    }
}


class Solution {

    public int[] solution(int[] arr, int[][] queries) {

        for (int[] query : queries) {
            for (int j = query[0]; j <= query[1]; j++) {
                arr[j] += 1;
            }
        }

        return arr;
    }
}