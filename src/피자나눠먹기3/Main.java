package 피자나눠먹기3;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int slice = 4;
        int n = 12;
        System.out.println(s.solution(slice, n));
    }
}

class Solution {
    public int solution(int slice, int n) {
        return (n % slice > 0) ? (n/slice) + 1 : n/slice;
    }
}