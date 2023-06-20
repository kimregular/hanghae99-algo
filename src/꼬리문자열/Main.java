package 꼬리문자열;

public class Main {
    public static void main(String[] args) {

        String[] strs = {"abc", "def", "ghi"};
        String ex = "ef";

        Solution s = new Solution();
        System.out.println(s.solution(strs, ex));
    }
}

class Solution {

    public String solution(String[] strs, String ex) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (!(str.contains(ex))) {
                sb.append(str);
            }
        }

        return sb.toString();
    }
}
