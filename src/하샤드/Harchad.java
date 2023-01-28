package 하샤드;


public class Harchad {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 11;
        System.out.println(s.solution(num));
    }
}

class Solution {
    public boolean solution(int x) {
        int origin = x;
        int tmp = 0;
        while (x > 0) {
            tmp += x % 10;
            x /= 10;
        }

        return origin % tmp == 0;
    }
}