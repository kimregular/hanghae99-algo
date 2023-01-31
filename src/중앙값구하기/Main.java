package 중앙값구하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1, 2, 7, 10, 11};
        System.out.println(s.solution(array));
    }
}


class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];
    }
}