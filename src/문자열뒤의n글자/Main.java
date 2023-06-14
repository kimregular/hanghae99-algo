package 문자열뒤의n글자;

public class Main {
    public static void main(String[] args) {

        String str = "ProgrammerS123";

        Solution s = new Solution();
        System.out.println(s.solution(str, 11));
    }
}


class Solution {

    public String solution(String str, int n) {
        return str.substring(str.length() - n);
    }
}