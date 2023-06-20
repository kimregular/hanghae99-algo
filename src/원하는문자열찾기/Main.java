package 원하는문자열찾기;

public class Main {
    public static void main(String[] args) {

        String str = "aaAA";
        String pat = "aaaaa";

        Solution s = new Solution();
        System.out.println(s.solution(str, pat));

    }
}


class Solution {
    public int solution(String str, String pat) {
        int answer = 0;
        str = str.toLowerCase();
        pat = pat.toLowerCase();
        if (str.contains(pat)) {
            answer = 1;
        }
        return answer;
    }
}