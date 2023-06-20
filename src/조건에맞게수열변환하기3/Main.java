package 조건에맞게수열변환하기3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 100, 99, 98};
        int n = 3;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, n)));

    }
}

class Solution {

    public int[] solution(int[] arr, int n) {

        if (isEven(n)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + n;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * n;
            }
        }

        return arr;
    }

    protected boolean isEven(int n) {
        return n % 2 == 0;
    }
}
