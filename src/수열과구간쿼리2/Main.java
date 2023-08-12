package 수열과구간쿼리2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, queries)));

    }
}

class Solution {

    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {
            int tmp = Integer.MAX_VALUE;
            boolean isChanged = false;

            for (int i = query[0]; i <= query[1]; i++) {
                if (arr[i] > query[2]) {
                    tmp = Math.min(tmp, arr[i]);
                    isChanged = true;
                }
            }
            if (isChanged) {
                answer.add(tmp);
            } else {
                answer.add(-1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
