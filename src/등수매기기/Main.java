package 등수매기기;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
//        int[][] score = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
//        int[][] score = {{1, 3}, {3, 1}, {2, 3}, {3, 2}, {1, 2}, {0, 0}};
//        int[][] score = {{1, 2}, {1, 1}, {1, 1}};
        System.out.println(Arrays.toString(s.solution(score)));
    }
}

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int[] nums : score) {
            arr.add(nums[0] + nums[1]);
        }
        arr.sort(Comparator.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            answer[i] = arr.indexOf(score[i][0] + score[i][1]) + 1;
        }
        return answer;
    }
}