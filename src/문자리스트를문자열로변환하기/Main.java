package 문자리스트를문자열로변환하기;

public class Main {
    public static void main(String[] args) {

        String[] strs = {"a", "b", "c"};
        Solution s = new Solution();
        System.out.println(s.solution(strs));
    }
}


class Solution {

    public String solution(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}