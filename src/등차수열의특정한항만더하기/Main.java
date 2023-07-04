package 등차수열의특정한항만더하기;

public class Main {
    public static void main(String[] args) {

        int a = 7;
        int b = 1;
        boolean[] arr = {false, false, false, true, false, false, false};

        Solution s = new Solution();
        System.out.println(s.solution(a, b, arr));
    }
}


class Solution {

    public int solution(int a, int b, boolean[] arr) {

        int cur = a;
        int result = 0;

        for (boolean b1 : arr) {

            if (b1) {
                result += cur;
            }

            cur += b;
        }

        return result;
    }
}