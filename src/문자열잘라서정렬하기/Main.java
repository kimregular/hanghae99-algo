package 문자열잘라서정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str = "axbxxxc";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));
    }

}

class Solution {

    public String[] solution(String str) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                if (sb.length() > 0) {
                    answer.add(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(str.charAt(i));
            }
        }

        if (sb.length() > 0) {
            answer.add(sb.toString());
        }

        answer.sort(Comparator.naturalOrder());

        return answer.toArray(new String[0]);
    }
}
