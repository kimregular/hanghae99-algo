package 공배수;

public class Main {
    public static void main(String[] args) {

        int number = 60;
        int n = 2;
        int m = 3;

        Solution s = new Solution();
        System.out.println(s.solution(number, n, m));

    }
}


class Solution {

    public int solution(int number, int n, int m) {

        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }

    }
}