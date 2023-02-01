package 배열회전;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        String direction = "left";
        System.out.println(Arrays.toString(s.solution(numbers, direction)));

    }
}


class Solution {
    public int[] solution(int[] numbers, String direction) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (direction.equals("right")) {
            answer.add(numbers[numbers.length - 1]);
            for (int i = 0; i < numbers.length-1; i++) {
                answer.add(numbers[i]);
            }
        }
        if (direction.equals("left")) {
            for (int i = 1; i < numbers.length; i++) {
                answer.add(numbers[i]);
            }
            answer.add(numbers[0]);
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }
}