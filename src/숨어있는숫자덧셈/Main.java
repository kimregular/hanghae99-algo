package 숨어있는숫자덧셈;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "1a2b3c4d123";
        System.out.println(s.solution(my_string));

    }
}

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
            }
        }
        return answer;
    }
}