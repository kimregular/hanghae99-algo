package jadenCase문자열만들기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "33 33 3";
        System.out.println(s.solution(str));
    }
}


class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] tmp = s.toCharArray();
        boolean flag = false;
        if (tmp[0] >= 'a' && tmp[0] <= 'z') {
            tmp[0] = (char) (tmp[0] - 32);
            answer.append(tmp[0]);
        } else {
            answer.append(tmp[0]);
        }

        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == ' ') {
                answer.append(tmp[i]);
                flag = true;
            }else if (flag) {
                if (tmp[i] >= 'a' && tmp[i] <= 'z') {
                    tmp[i] = (char) (tmp[i] - 32);
                }
                answer.append(tmp[i]);
                flag = false;
            } else if (tmp[i] >= 'A' && tmp[i] <= 'Z') {
                tmp[i] = (char) (tmp[i] + 32);
                answer.append(tmp[i]);

            } else {
                answer.append(tmp[i]);
            }

        }
        return answer.toString();
    }
}