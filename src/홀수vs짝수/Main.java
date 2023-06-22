package 홀수vs짝수;

public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 2, 6, 1, 7, 6};

        Solution s = new Solution();
        System.out.println(s.solution(arr));

    }
}


class Solution {

    public int solution(int[] arr) {
        int evens = 0;
        int odds = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                odds += arr[i];
            } else {
                evens += arr[i];
            }
        }

        return Math.max(evens, odds);
    }
}