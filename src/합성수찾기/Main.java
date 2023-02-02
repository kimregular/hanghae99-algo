package 합성수찾기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 15;
        System.out.println(s.solution(n));

    }
}


class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i+1; j++) {
                if (i % j == 0) {
                    cnt++;
                }
                if (cnt > 2) {
                    answer++;
                    cnt = 0;
                    break;
                }
            }
            cnt = 0;
        }
        return answer;
    }
}