package 문자열정수바꾸기;

public class StrToInt {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("-1234"));
    }
}

class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
