package 약수구하기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 24;
        System.out.println(Arrays.toString(s.solution(n)));
    }
}


class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (n % i == 0) {
                answer.add(i);
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.stream().mapToInt(i -> i).toArray();
    }
}