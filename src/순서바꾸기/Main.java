package 순서바꾸기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 1, 6};
        int n = 1;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, n)));
    }
}

class Solution {

    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        int[] tail = Arrays.copyOfRange(arr, n, arr.length);
        int[] head = Arrays.copyOfRange(arr, 0, n);

        System.arraycopy(tail, 0, answer, 0, tail.length);
        System.arraycopy(head, 0, answer, tail.length, head.length);
        return answer;

    }
}
