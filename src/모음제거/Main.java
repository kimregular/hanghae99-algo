package 모음제거;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "nice to meet you";
        System.out.println(s.solution(my_string));

    }
}


class Solution {
    public String solution(String my_string) {
        String[] consonants = {"a", "e", "i", "o", "u"};
        for (String consonant : consonants) {
            my_string = my_string.replaceAll(consonant, "");
        }
        return my_string;
    }
}