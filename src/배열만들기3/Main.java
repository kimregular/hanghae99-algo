package 배열만들기3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"0123456789","9876543210", "9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;

        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.solution(strs, k, s, l)));

    }
}

class Solution {

    public int[] solution(String[] strs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            for (int i = s; i <= s+l - 1; i++) {
                sb.append(str.charAt(i));
            }
            int tmp = Integer.parseInt(sb.toString());
            if (tmp > k) {
                answer.add(tmp);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
