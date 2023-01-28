package 정수내림차순;

import java.util.ArrayList;
import java.util.Comparator;

public class DescendingOrder {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 118372;
        System.out.println(s.solution(n));
    }
}

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        arr.sort(Comparator.reverseOrder());
        for (Long num : arr) {
            answer *= 10;
            answer += num;
        }
        return answer;
    }
}