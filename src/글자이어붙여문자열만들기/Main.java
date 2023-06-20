package 글자이어붙여문자열만들기;

public class Main {
    public static void main(String[] args) {

        String str = "cvsgiorszzzmrpaqpe";
        int[] idx = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};

        Solution s = new Solution();
        System.out.println(s.solution(str, idx));
    }
}

class Solution {

    public String solution(String str, int[] idx) {
        StringBuilder sb = new StringBuilder();
        for (int i : idx) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
