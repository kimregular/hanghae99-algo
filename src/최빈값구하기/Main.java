package 최빈값구하기;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arr = {1, 2, 3, 3, 3, 4};
        System.out.println(s.solution(arr));

    }
}

class Solution {
    public int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int answer = 0;
        int val = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (val < entry.getValue()) {
                val = entry.getValue();
                answer = entry.getKey();
            }
        }

        int cnt = 0;
        for (Integer value : map.values()) {
            if (value == val) {
                cnt++;
            }
        }
        if (cnt > 1) {
            return -1;
        } else {
            return answer;
        }
    }
}
