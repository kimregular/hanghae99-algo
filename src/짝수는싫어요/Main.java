package 짝수는싫어요;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 15;
        System.out.println(Arrays.toString(s.solution(n)));
    }
}

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n/2) + n%2];
        int num = 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num;
            num += 2;
        }
        return answer;
    }
}