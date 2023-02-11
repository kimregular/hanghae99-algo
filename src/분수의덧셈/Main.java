package 분수의덧셈;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int numer1 = 1;
        int denom1 = 2;
        int numer2 = 3;
        int denom2 = 4;
        System.out.println(Arrays.toString(s.solution(numer1, denom1, numer2, denom2)));
    }
}

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int number = (numer1 * denom2) + (numer2 * denom1);
        int denum = denom1 * denom2;

        int gcd = GCD(number, denum);

        return new int[]{number/gcd, denum/gcd};
    }

    public int GCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return GCD(num2, num1 % num2);
        }
    }
}