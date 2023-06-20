package 문자열겹쳐쓰기;

public class Main {
    public static void main(String[] args) {

        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int n = 2;

        Solution s = new Solution();
        System.out.println(s.solution(my_string, overwrite_string, n));
    }
}


class Solution {

    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder pre = new StringBuilder(my_string.substring(0, s)).append(overwrite_string);
        String sub = my_string.substring(pre.length());
        pre.append(sub);
        return pre.toString();
    }
}