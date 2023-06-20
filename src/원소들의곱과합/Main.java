package 원소들의곱과합;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr = {5,7,8,3};

        System.out.println(s.solution(arr));
    }
}


class Solution {

    public int solution(int[] arr) {
        int sum = 0;
        int mul = 1;

        for (int i : arr) {
            sum += i;
            mul *= i;
        }

        sum *= sum;

        if (mul < sum) {
            return 1;
        } else {
            return 0;
        }
    }
}