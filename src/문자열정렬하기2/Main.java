package 문자열정렬하기2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "Bcad";
        System.out.println(s.solution(my_string));

    }
}


class Solution {
    public String solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        String[] strs = my_string.split("");
        for (String str : strs) {
            answer.add(str.toLowerCase());
        }

        answer.sort(Comparator.naturalOrder());
        return String.join("", answer);
    }
}