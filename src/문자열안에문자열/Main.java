package 문자열안에문자열;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str1 = "ab6CDE443fgh22iJKlmn1o";
        String str2 = "6CD";
        System.out.println(s.solution(str1, str2));
    }
}


class Solution {
    public int solution(String str1, String str2) {

        String test = str1.replaceAll(str2, " ");
        if (str1.equals(test)) {
            return 2;
        }

        return 1;
    }
}