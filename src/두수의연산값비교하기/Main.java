package 두수의연산값비교하기;

public class Main {
    public static void main(String[] args) {

        int a = 2;
        int b = 91;

        Solution s = new Solution();
        System.out.println(s.solution(a, b));
    }
}

class Solution {

    public int solution(int a, int b) {
        int num1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int num2 = 2 * a * b;
        return Math.max(num1 , num2);
    }

}
