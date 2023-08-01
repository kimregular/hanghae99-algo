package 특정문자열로끝나는가장긴부분문자열찾기;

public class Main {
    public static void main(String[] args) {
        String str = "AbCdEFG";
        String pat = "dE";

        Solution s = new Solution();
        System.out.println(s.solution(str, pat));

    }
}

class Solution {

    public String solution(String str, String pat) {
        int idx = str.lastIndexOf(pat);

        return str.substring(0, idx) + pat;
    }
}
