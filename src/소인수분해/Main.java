package 소인수분해;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 1;
        System.out.println(Arrays.toString(s.solution(n)));
    }
}


class Solution {
    public int[] solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;

            }
        }

        int[] answer = set.stream().mapToInt(o -> o).toArray();
        Arrays.sort(answer);
        return answer;
    }
}