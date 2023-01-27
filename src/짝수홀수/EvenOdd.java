package 짝수홀수;

public class EvenOdd {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(5));
    }
}

class Solution {
    public String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}