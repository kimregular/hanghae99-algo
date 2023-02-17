package 올바른괄호;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(()(";
        System.out.println(s.solution(str));
    }
}

class Solution {
    boolean solution(String s) {
        int cnt = 0;

        for (char str : s.toCharArray()) {
            if (str == '(') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return false;
                } else {

                    cnt--;
                }
            }
        }
        return cnt == 0;
    }
}