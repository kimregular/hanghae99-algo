package 문자열다루기기본;

public class BasicStrModify {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "a234";
        System.out.println(s.solution(str));
    }
}

class Solution {
    public boolean solution(String s) {

        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        if (s.length() == 4 || s.length() == 6) {
            return true;
        }
        return false;
    }
}