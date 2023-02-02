package 피자나눠먹기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        System.out.println(s.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int gcd = GCD(n, 6);
        answer = (n * 6) / gcd;
        return answer/6;
    }

    public int GCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return GCD(num2, num1 % num2);
        }
    }
}