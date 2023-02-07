package 문자열계산하기;



public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "1 - 20 + 30 - 4";
        System.out.println(s.solution(my_string));

    }
}
class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");
        int answer = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i += 2) {
            String sign = str[i];
            answer = (sign.equals("+")) ? answer + Integer.parseInt(str[i + 1]) : answer - Integer.parseInt(str[i + 1]);
        }
        return answer;
    }
}