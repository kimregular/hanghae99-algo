package 구로나눈나머지;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        String number = "78720646226947352489";

        Solution s = new Solution();
        System.out.println(s.solution(number));

    }
}

class Solution {

    public int solution(String number) {
        BigInteger bigInteger = new BigInteger(number);
        BigInteger answer = bigInteger.mod(BigInteger.valueOf(9));
        return answer.intValue();

    }
}