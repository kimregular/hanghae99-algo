package 배열자르기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1, 2, 3, 4, 5};
        int num1 = 1;
        int num2 = 3;
        System.out.println(Arrays.toString(s.solution(numbers, num1, num2)));
    }
}

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = num1; i < num2+1; i++) {
            answer.add(numbers[i]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}