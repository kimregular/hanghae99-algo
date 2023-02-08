package 구슬을나누는경우의수;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int balls = 30;
        int share = 15;
        System.out.println(s.solution(balls, share));

    }
}

class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger answer = BigInteger.ONE;
        BigInteger tmp = BigInteger.ONE;
        for (int i = balls; i > balls - share; i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i < share + 1; i++) {
            tmp = tmp.multiply(BigInteger.valueOf(i));
        }
        return answer.divide(tmp);
    }
}