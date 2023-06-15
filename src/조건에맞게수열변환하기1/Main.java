package 조건에맞게수열변환하기1;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 100, 99, 98};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50) {
                if (arr[i] % 2 == 0) {
                    int tmp = arr[i];
                    arr[i] = tmp / 2;
                }
            } else {
                if (arr[i] % 2 != 0) {
                    int tmp = arr[i];
                    arr[i] = tmp * 2;
                }
            }
        }
        return arr;
    }
}
