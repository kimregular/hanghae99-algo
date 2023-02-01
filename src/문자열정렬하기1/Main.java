package 문자열정렬하기1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "hi12392";
        System.out.println(Arrays.toString(s.solution(my_string)));

    }
}

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {

                answer.add((my_string.charAt(i) - 48));
            }
        }
        answer.sort(Comparator.naturalOrder());

        return answer.stream().mapToInt(i -> i).toArray();
    }
}