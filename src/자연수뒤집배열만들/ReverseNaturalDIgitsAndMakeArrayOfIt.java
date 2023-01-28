package 자연수뒤집배열만들;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseNaturalDIgitsAndMakeArrayOfIt {
    public static void main(String[] args) {
        Solution s = new Solution();
        long n = 12345;
        System.out.println(Arrays.toString(s.solution(n)));
    }
}


class Solution {
    public int[] solution(long n) {
        String tmp = String.valueOf(n);
        int[] answer = new int[tmp.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }


        return answer;
    }
}