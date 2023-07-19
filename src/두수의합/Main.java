package 두수의합;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        String num1 = "18446744073709551615";
        String num2 = "287346502836570928366";
        Solution s = new Solution();
        System.out.println(s.solution(num1, num2));

    }
}

class Solution{

    public String solution(String num1, String num2) {
        BigInteger bNum1 = new BigInteger(num1);
        BigInteger bNum2 = new BigInteger(num2);

        BigInteger sum = bNum1.add(bNum2);

        return String.valueOf(sum);
    }
}
