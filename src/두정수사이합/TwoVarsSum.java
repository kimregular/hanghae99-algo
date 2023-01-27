package 두정수사이합;

public class TwoVarsSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, 5));
    }
}

class Solution {
    public long solution(int a, int b) {
        int sum = 0;
        if (a > b) {
            for (int i = a; i > b - 1; i--) {
                sum += i;
            }
        } else {
            for (int i = a; i < b + 1; i++) {
                sum += i;
            }
        }
        return sum;
    }
}
