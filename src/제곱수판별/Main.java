package 제곱수판별;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 976;
        System.out.println(s.solution(n));
    }
}


class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i * i < n + 1; i++) {
            if (n == i * i) {
                answer = 1;
            }
        }

        if (answer == 0) {
            answer = 2;
        }
        return answer;
    }
}