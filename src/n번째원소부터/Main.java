package n번째원소부터;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 1, 6};
        int n = 3;

        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(arr, n)));

    }
}

class Solution {

    public int[] solution(int[] arr, int n) {
        return Arrays.copyOfRange(arr, n - 1, arr.length);
    }
}
