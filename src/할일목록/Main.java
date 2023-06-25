package 할일목록;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] str1 = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str1, finished)));

    }
}


class Solution {

    public String[] solution(String[] str1, boolean[] finished) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < str1.length; i++) {
            if (!finished[i]) {
                answer.add(str1[i]);
            }
        }

        return answer.toArray(new String[0]);
    }

}