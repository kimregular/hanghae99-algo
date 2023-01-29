package 로또순위;


import java.util.Arrays;
import java.util.HashMap;

public class LottoHighLow {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(s.solution(lottos, win_nums)));
    }
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int bestCase = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : win_nums) {
            hMap.put(num, hMap.getOrDefault(num, 0));
        }

        for (int num : lottos) {
            if (num == 0) {
                bestCase++;
            } else if (hMap.containsKey(num)) {
                hMap.put(num, hMap.get(num) + 1);
            }
        }

        int worstCase = 0;
        for (int num : hMap.values()) {
            if (num == 1) {
                bestCase++;
                worstCase++;
            }
        }
        int[] answer = new int[2];
        answer[0] = 7 - bestCase;
        if (bestCase == 0) {
            answer[0] = 6;
        } else {
            answer[1] = 7 - bestCase;
        }
        if (worstCase == 0) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - worstCase;
        }

        return answer;
    }
}
//[1, 2, 3, 4, 5, 6] [7, 8, 9, 10, 11, 12] [6,6]