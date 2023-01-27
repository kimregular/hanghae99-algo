package X간격;

public class XDiffer {
    public static void main(String[] args) {
        Solution s = new Solution();
        int x = 2;
        int n = 5;
        System.out.println(s.solution(x, n));
    }
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long tmp = x;
        for (int i = 0; i < n; i++) {
            answer[i] = tmp;
            tmp += x;
        }

        return answer;
    }
}