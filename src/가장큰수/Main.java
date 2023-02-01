package 가장큰수;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {9, 10, 11, 8};
        System.out.println(Arrays.toString(s.solution(array)));

    }
}


class Solution {
    public int[] solution(int[] array) {

        int idx = 0;
        int max = 0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i] > max) {
                max = array[i];
                idx = i;
            }
        }
        return new int[]{max, idx};
    }
}