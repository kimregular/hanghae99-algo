package 주사위게임1;

public class Main {
    public static void main(String[] args) {

        int a = 3;
        int b = 5;

        Solution s = new Solution();
        System.out.println(s.solution(a, b));

    }
}


class Solution {

    public int solution(int a, int b) {
        if (odds(a, b)) {
            return a * a + b * b;
        } else if (odd(a, b)) {
            return 2 * (a + b);
        } else {
            return Math.abs(a - b);
        }
    }

    protected boolean odds(int a, int b) {
        return (a % 2 != 0) && (b % 2 != 0);
    }

    protected boolean odd(int a, int b) {
        return (a % 2 != 0) || (b % 2 != 0);
    }
}