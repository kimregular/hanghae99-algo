package 삼진수뒤집기;


public class TernaryNotation {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 125;
        System.out.println(s.solution(n));
    }
}

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        sb.reverse();
        return Integer.parseInt(sb.toString(), 3);
    }
}