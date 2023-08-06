package qr코드;

public class Main {
    public static void main(String[] args) {

        int q = 3;
        int r = 1;
        String code = "qjnwezgrpirldywt";

        Solution s = new Solution();
        System.out.println(s.solution(q, r, code));

    }
}

class Solution {

    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                sb.append(code.charAt(i));
            }
        }

        return sb.toString();
    }
}
