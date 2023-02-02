package 중복된문자제거;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "We are the world";
        System.out.println(s.solution(my_string));
    }
}


class Solution {
    public String solution(String my_string) {
        LinkedHashSet<String> answer = new LinkedHashSet<>();
        for (String str : my_string.split("")) {
            answer.add(str);
        }
        return String.join("", answer);
    }
}