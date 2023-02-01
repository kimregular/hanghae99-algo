package n의배수고르기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.toString(s.solution(n, numlist)));

    }
}


class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int num : numlist) {
            if (num % n == 0) {
                answer.add(num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}