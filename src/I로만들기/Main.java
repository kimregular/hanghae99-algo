package I로만들기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String str = "jjnnllkkmm";
        Solution s = new Solution();
        System.out.println(s.solution(str));

    }
}

class Solution {

    public String solution(String str) {
        char[] tmp = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] < 'l') {
                sb.append("l");
            } else {
                sb.append(tmp[i]);
            }
        }

        return sb.toString();
    }
}
