package 뒤에서5등까지;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {12, 4, 15, 46, 38, 1, 14};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));

    }
}


class Solution {

    public int[] solution(int[] arr) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, 5);
    }
}