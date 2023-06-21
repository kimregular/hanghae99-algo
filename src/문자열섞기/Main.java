package 문자열섞기;

public class Main {
    public static void main(String[] args) {

        String str1 = "aaaa";
        String str2 = "bbbb";

        Solution s = new Solution();
        System.out.println(s.solution(str1, str2));

    }
}


class Solution {

    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }

        return sb.toString();
    }
}