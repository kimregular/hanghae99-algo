package 세로읽기;

public class Main {
    public static void main(String[] args) {

        String str = "programmers";
        int m = 1;
        int c = 1;
        Solution s = new Solution();
        System.out.println(s.solution(str, m, c));

    }
}

class Solution {

    public String solution(String str, int m, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += m) {
            String tmp = str.substring(i, i + m);
            sb.append(tmp.charAt(c-1));
        }

        return sb.toString();
    }
}
