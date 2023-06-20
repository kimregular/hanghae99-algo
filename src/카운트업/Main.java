package 카운트업;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int start = 3;
        int end = 10;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(start, end)));

    }
}

class Solution {

    public int[] solution(int start, int end) {
        int len = end - start;
        int[] arr = new int[len+1];

        int idx = 0;
        for (int i = start; i < end + 1; i++) {
            arr[idx++] = i;
        }

        return arr;
    }
}
