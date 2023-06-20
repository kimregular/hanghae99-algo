package n보다커질때까지더하기;

public class Main {
    public static void main(String[] args) {

        int[] arr = {34, 5, 71, 29, 100, 34};
        int n = 123;

        Solution s = new Solution();
        System.out.println(s.solution(arr, n));
    }
}

class Solution {

    public int solution(int[] arr, int n) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (result > n) {
                return result;
            }
        }

        return -1;
    }
}
