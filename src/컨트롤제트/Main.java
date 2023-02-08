package 컨트롤제트;

import java.time.format.ResolverStyle;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "10 20 30 40";
        System.out.println(s.solution(str));

    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {

            if (str[i].equals("Z")) {
                answer -= Integer.parseInt(str[i-1]);
            } else {
                answer += Integer.parseInt(str[i]);
            }
        }
        return answer;
    }
}