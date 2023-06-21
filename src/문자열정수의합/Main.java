package 문자열정수의합;

public class Main {
    public static void main(String[] args) {

        String str = "10000000000";
        Solution s = new Solution();
        System.out.println(s.solution(str));
    }
}

class Solution {

    public int solution(String str) {
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            answer += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return answer;
    }
}
