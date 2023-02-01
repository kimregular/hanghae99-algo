package 세균증식;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 2;
        int t = 10;
        System.out.println(s.solution(n, t));
    }
}


class Solution {
    public int solution(int n, int t) {
        for (int i = 0; i < t; i++) {
            n *= 2;
        }
        return n;
    }
}