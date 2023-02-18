package 로그인성공;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] id_pw = {"programmer01", "15789"};
        String[][] db = {{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}};
        System.out.println(s.solution(id_pw, db));

    }
}


class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for (String[] data : db) {
            if (data[0].equals(id_pw[0])) {
                answer = "wrong pw";
                if (data[1].equals(id_pw[1])) {
                    answer = "login";
                    break;
                }
            }

        }
        return answer;
    }
}