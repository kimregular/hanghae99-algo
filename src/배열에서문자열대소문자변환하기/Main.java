package 배열에서문자열대소문자변환하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] strs = {"aaa", "BBB", "CCC", "ddd"};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(strs)));
    }
}

class Solution {

    public String[] solution(String[] strs) {
        String[] answer = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (i % 2 == 0) {
                answer[i] = strs[i].toLowerCase();
            } else {
                answer[i] = strs[i].toUpperCase();
            }
        }

        return answer;
    }
}