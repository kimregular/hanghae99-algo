package 배열의길이를2의거듭제곱으로만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arr = {58, 172, 746, 89};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));

    }
}


class Solution {

    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            answer.add(i);
        }

        int arrLen = arr.length;
        int cnt = 1;

        while (arrLen > cnt) {
            cnt *= 2;
        }

        int howMany = cnt - arrLen;

        for (int i = 0; i < howMany; i++) {
            answer.add(0);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}