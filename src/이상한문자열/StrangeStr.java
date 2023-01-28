package 이상한문자열;

import java.util.Arrays;

public class StrangeStr {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "  abc de  fghi";
        System.out.println(s.solution(str));
    }
}

class Solution {
    public String solution(String s) {

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));
            if (tmp.equals(" ")) {
                sb.append(tmp);
                idx = 0;
            } else if (idx % 2 == 0) {
                sb.append(tmp.toUpperCase());
                idx++;
            } else {
                sb.append(tmp.toLowerCase());
                idx++;
            }
        }


        return String.valueOf(sb);
    }
}
// " AbC   AbC   AbC "

//"  abc de  fghi   "
//"  AbC De  FgHi   "