package 문자열을정수로변환하기;

public class Main {
    public static void main(String[] args) {

        String str = "8542";

        Solution s = new Solution();
        System.out.println(s.solution(str));

    }
}

class Solution {

    public int solution(String str) {
        return Integer.parseInt(str);
    }
}
