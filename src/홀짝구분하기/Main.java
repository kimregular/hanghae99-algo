package 홀짝구분하기;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 100;

        s.solution(n);
    }
}

class Solution {
    public void solution(int n) {
        if (n % 2 == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }
    }
}
