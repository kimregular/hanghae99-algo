package 가운데글자;


public class MiddleChar {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("qwer"));
    }
}

class Solution {
    public String solution(String s) {
        if (s.length() % 2 != 0) {
            return s.substring(s.length() / 2,s.length() / 2+1);
        }
        return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
    }
}
