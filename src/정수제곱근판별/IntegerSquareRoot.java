package 정수제곱근판별;

public class IntegerSquareRoot {
    public static void main(String[] args) {
        Solution s = new Solution();
        long n = 5;
        System.out.println(s.solution(n));
    }
}

class Solution {
    public long solution(long n) {
        boolean flag = false;
        long answer = 0;

        for (long i = 1; i * i <= n; i++) {
            if (i * i == n) {
                flag = true;
                answer = i;
            }
        }

        if (flag) {
            answer = (answer+1) * (answer+1);
            return answer;
        }
        answer = -1;
        return answer;
    }
}