package 부분문자열;

public class Main {
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "aabcc";

        Solution s = new Solution();
        System.out.println(s.solution(str1, str2));

    }
}

class Solution {

    public int solution(String str1, String str2) {
        if (str2.contains(str1)) {
            return 1;
        } else {
            return 0;
        }
    }
}
