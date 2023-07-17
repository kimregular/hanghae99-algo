package 배열만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181895
 * 배열 만들기 3
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, intervals)));

    }
}


class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer.add(arr[j]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}