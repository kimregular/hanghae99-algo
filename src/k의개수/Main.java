package k의개수;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = 1;
        int j = 13;
        int k = 1;
        System.out.println(s.solution(i, j, k));

    }
}


class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int l = i; l < j+1; l++) {
            String[] tmp = String.valueOf(l).split("");
            for (String num : tmp) {
                if (num.equals(String.valueOf(k))) {
                    answer++;
                }
            }
        }
        return answer;
    }
}