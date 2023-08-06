package 문자개수세기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String str = "Programmers";
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));
    }
}


class Solution {

    public int[] solution(String str) {
        int[] answer = new int[52];

        for (char c : str.toCharArray()) {
            if (c >= 'a') {
                answer[c - 'a' + 26]++;
            } else {
                answer[c - 'A']++;
            }
        }


        return answer;
    }
}
