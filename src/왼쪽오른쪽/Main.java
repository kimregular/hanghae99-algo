package 왼쪽오른쪽;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] str_list = {"u", "r" ,"d"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str_list)));

    }
}


class Solution {

    public String[] solution(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, i);
            } else if (str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i+1, str_list.length);
            }
        }

        return new String[0];
    }
}