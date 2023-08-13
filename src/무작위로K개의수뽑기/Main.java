package 무작위로K개의수뽑기;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 1, 1};
        int k = 4;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, k)));
    }
}

class Solution {

    public int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();

        int cnt = 0;
        for (int i : arr) {
            if (!(answer.contains(i))) {
                answer.add(i);
                cnt++;
            }
            if (cnt == k) {
                break;
            }
        }


        if (answer.size() < k) {
            while (answer.size() != k) {
                answer.add(-1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
