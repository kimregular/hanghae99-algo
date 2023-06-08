package n의배수;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int num = 34;
        int n = 3;
        System.out.println(s.solution(num, n));

    }
}

class Solution{
    public int solution(int num, int n) {
        int flag = num % n;
        if (flag == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
