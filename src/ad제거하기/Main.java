package ad제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ad 제거하샘
 * https://school.programmers.co.kr/learn/courses/30/lessons/181870
 */
public class Main {
    public static void main(String[] args) {

        String[] str = {"and", "notad", "abcd"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));

    }
}

class Solution {

    public String[] solution(String[] strs) {
        List<String> answer = new ArrayList<>();
        for (String str : strs) {
            if (!(str).contains("ad")) {
                answer.add(str);
            }
        }

        return answer.toArray(new String[0]);
    }
}
