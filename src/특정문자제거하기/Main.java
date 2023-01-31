package 특정문자제거하기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "abcdef";
        String letter = "f";
        System.out.println(s.solution(my_string, letter));
    }
}

class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!(String.valueOf(my_string.charAt(i)).equals(letter))) {
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}