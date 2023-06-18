package 카운트다운;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int start = 11;
        int end = 3;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(start, end)));

    }
}

class Solution {

    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];

        int idx = 0;

        for (int i = start; i >= end; i--) {
            answer[idx++] = i;
        }

        return answer;
    }
}
