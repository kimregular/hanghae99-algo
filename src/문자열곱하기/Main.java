package 문자열곱하기;

public class Main {
    public static void main(String[] args) {

        String str = "string";
        int n = 3;

        Solution s = new Solution();
        System.out.println(s.solution(str, n));

    }
}


class Solution {

    public String solution(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}