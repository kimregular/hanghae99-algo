package 대문자소문자;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "cccCCC";
        System.out.println(s.solution(my_string));

    }
}


class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z') {
                answer.append((char)(my_string.charAt(i) - 32));
            } else {
                answer.append((char)(my_string.charAt(i) + 32));
            }
        }
        return answer.toString();
    }
}