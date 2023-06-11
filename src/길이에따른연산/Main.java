package 길이에따른연산;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arr = {2, 3, 4, 5};
        System.out.println(s.solution(arr));
    }
}

class Solution {

    public int solution(int[] arr) {
        int result = 0;

        if (arr.length >= 11) {
            for (int i : arr) {
                result += i;
            }
        } else {
            result = 1;
            for (int i : arr) {
                result *= i;
            }
        }

        return result;
    }
}
