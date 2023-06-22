package 홀짝에따라다른값반환하기;

public class Main {
    public static void main(String[] args) {

        int n = 10;

        Solution s = new Solution();
        System.out.println(s.solution(n));

    }
}

class Solution {

    public int solution(int n) {
        int result = 0;
        if (n % 2 == 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    result += i * i;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    result += i;
                }
            }
        }

        return result;
    }
}
