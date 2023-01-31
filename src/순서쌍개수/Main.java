package 순서쌍개수;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 100;
        System.out.println(s.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}