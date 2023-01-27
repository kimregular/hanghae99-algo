package 내적;

public class Inner {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(s.solution(a, b));

    }
}

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}