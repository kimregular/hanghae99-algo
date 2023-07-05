package 빈배열에추가삭제하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, flag)));

    }
}


class Solution {

    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[idx]) {
                for (int j = 0; j < arr[idx] * 2; j++) {
                    answer.add(arr[idx]);
                }
            } else {
                for (int j = 0; j < arr[idx]; j++) {
                    answer.remove(answer.size() - 1);
                }
            }
            idx++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}