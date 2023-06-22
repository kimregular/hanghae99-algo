package 배열의길이에따라다른연산하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {49, 12, 100, 276, 33};
        int n = 27;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, n)));
    }
}


class Solution {

    public int[] solution(int[] arr, int n) {
        int LEN = arr.length;

        if (LEN % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 != 0) {
                    arr[i] += n;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    arr[i] += n;
                }
            }
        }

        return arr;
    }
}