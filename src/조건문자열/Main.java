package 조건문자열;

public class Main {
    public static void main(String[] args) {

        String ineq = "<";
        String eq = "=";

        int n = 20;
        int m = 50;

        Solution s = new Solution();
        System.out.println(s.solution(ineq, eq, n, m));
    }
}


class Solution {

    public int solution(String ineq, String eq, int n, int m) {
        boolean flag = false;
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                flag = n <= m;
            } else {
                flag = n < m;
            }
        } else {
            if (eq.equals("=")) {
                flag = n >= m;
            } else {
                flag = n > m;
            }
        }

        return flag ? 1 : 0;
    }
}