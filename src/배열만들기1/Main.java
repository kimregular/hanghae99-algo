package 배열만들기1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int n = 10;
        int k = 3;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n, k)));
    }
}

class Solution {

    public int[] solution(int n, int k) {
        int len = n / k;
        int[] answer = new int[len];

        int idx = 0;
        for (int i = k; i <= n; i+= k) {
            answer[idx++] = i;
        }

        return answer;
    }
}
