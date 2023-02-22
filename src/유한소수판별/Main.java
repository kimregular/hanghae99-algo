package 유한소수판별;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 11;
        int b = 22;
        System.out.println(s.solution(a, b));
    }
}

class Solution {
    public int solution(int a, int b) {
        int num = b / GCD(a, b);

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return 2;
            }
        }
        return 1;
    }

    public int GCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return GCD(num2, num1 % num2);
        }
    }
}