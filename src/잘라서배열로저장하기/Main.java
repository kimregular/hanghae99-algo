package 잘라서배열로저장하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_str = "abcdef123";
        int n = 3;
        System.out.println(Arrays.toString(s.solution(my_str, n)));
    }
}

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length() / n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = my_str.substring(0, n);
            my_str = my_str.substring(n);
        }

        if (my_str.length() > 0) {
            String[] tmp = new String[answer.length + 1];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            tmp[tmp.length - 1] = my_str;
            answer = tmp;
        }

        return answer;
    }
}
