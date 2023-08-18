package 배열조각하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, query)));
    }
}

class Solution {

    public int[] solution(int[] arr, int[] query) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            answer.add(i);
        }

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                answer = answer.subList(0, query[i]+1);
            } else {
                answer = answer.subList(query[i], answer.size());
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();

    }
}
