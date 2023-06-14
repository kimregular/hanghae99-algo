package n번째원소까지;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 7, 5};
        int n = 3;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, n)));
    }
}

class Solution {

    public int[] solution(int[] arr, int n) {
        int[] answer = new int[n];

        System.arraycopy(arr, 0, answer, 0, n);

        return answer;
    }
}
