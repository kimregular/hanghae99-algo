package 팩토리얼;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 1;
        System.out.println(s.solution(n));
    }
}


class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 2; i < n + 2; i++) {
            if (answer > n) {
                return i - 2;
            } else if (answer >= n) {
                return i - 1;
            }
            answer *= i;
        }
        return answer;
    }
}