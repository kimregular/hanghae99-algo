package 다섯명씩;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] str = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));

    }
}


class Solution {

    public String[] solution(String[] str) {
        int LEN = (str.length / 5);
        if (str.length % 5 != 0) {
            LEN++;
        }

        String[] answer = new String[LEN];
        int idx = 0;
        for (int i = 0; i < str.length; i += 5) {
            answer[idx++] = str[i];
        }

        return answer;
    }
}