package 접미사배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str = "banana";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));

    }
}


class Solution {

    public String[] solution(String str) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            String tmp = str.substring(i);
            answer.add(tmp);
        }

        answer.sort(Comparator.naturalOrder());

        return answer.toArray(new String[0]);
    }

}