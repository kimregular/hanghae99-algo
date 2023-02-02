package 가까운수;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {10, 11, 12, 14};
        int n = 13;
        System.out.println(s.solution(array, n));
    }
}


class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int tmp = 0;
        Arrays.sort(array);
        int small = Integer.MAX_VALUE;
        for (int num : array) {
            tmp = Math.abs(n - num);
            if (tmp < small) {
                small = tmp;
                answer = num;
            }

        }


        return answer;
    }
}