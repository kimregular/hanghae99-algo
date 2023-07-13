package 간단한논리연산;

public class Main {
    public static void main(String[] args) {

        boolean x1 = false;
        boolean x2 = true;
        boolean x3 = true;
        boolean x4 = true;

        Solution s = new Solution();
        System.out.println(s.solution(x1, x2, x3, x3));

    }
}

class Solution {

    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }
}
