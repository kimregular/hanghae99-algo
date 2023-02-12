package 공던지기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1, 2, 3, 4};
        int k = 2;
        System.out.println(s.solution(numbers, k));

    }
}

class Solution {
    public int solution(int[] numbers, int k) {
        int n = numbers.length;
        int idx = (k - 1 + n) % n;
        return numbers[idx];
    }
}