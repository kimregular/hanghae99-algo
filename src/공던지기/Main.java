package 공던지기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1,2,3};
        int k = 3;
        System.out.println(s.solution(numbers, k));

    }
}

class Solution {
    public int solution(int[] numbers, int k) {
        int getBall = 0;
        for (int i = 0; i < k - 1; i++) {
            getBall += 2;
        }
        getBall %= numbers.length;
        return numbers[getBall];
    }
}