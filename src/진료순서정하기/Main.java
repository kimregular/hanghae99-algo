package 진료순서정하기;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] emergency = {30, 10, 23, 6, 100};
        System.out.println(Arrays.toString(s.solution(emergency)));
    }
}


class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        int cur = 0;
        for (int num : emergency) {
            int order = emergency.length;
            for (int j : emergency) {
                if (num > j) {
                    order--;
                }
            }
            answer[cur] = order;
            cur++;
        }
        return answer;
    }
}