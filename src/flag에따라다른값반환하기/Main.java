package flag에따라다른값반환하기;

public class Main {
    public static void main(String[] args) {

        int a = -4;
        int b = 7;
        boolean flag = false;

        Solution s = new Solution();
        System.out.println(s.solution(a, b, flag));
    }
}

class Solution {

    public int solution(int a, int b, boolean flag) {
        if (flag) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
