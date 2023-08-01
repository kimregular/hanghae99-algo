package 세개의구분자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String myString = "cabab";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(myString)));
    }
}

class Solution {

    public String[] solution(String myStrings) {

        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : myStrings.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (sb.length() != 0) {
                    answer.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            answer.add(sb.toString());
        }

        return answer.size() > 0 ? answer.toArray(new String[0]) : new String[]{"EMPTY"};

    }
}
