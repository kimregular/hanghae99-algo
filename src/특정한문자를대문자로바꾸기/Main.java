package 특정한문자를대문자로바꾸기;

public class Main {
    public static void main(String[] args) {

        String str = "programmers";
        String alp = "p";

        Solution s = new Solution();
        System.out.println(s.solution(str, alp));
    }
}


class Solution {

    public String solution(String str, String alp) {
        return str.replaceAll(alp, alp.toUpperCase());
    }
}