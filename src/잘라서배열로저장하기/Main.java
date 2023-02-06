package 잘라서배열로저장하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_str = "abc1Addfggg4556b";
        int n = 6;
        System.out.println(Arrays.toString(s.solution(my_str, n)));
    }
}

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length() / n];
        for (int i = 0; i < my_str.length() / n; i++) {
            answer[i] = my_str.substring( n*i , n * (i+1));
        }

        return answer;
    }
}
