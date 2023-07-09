package x사이의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str = "oxooxoxxox";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));

    }
}


class Solution {

    public int[] solution(String str) {
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                answer.add(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}