package 배열의두배만들기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1,2,3,4,5};
        System.out.println(Arrays.toString(s.solution(numbers)));
    }
}
class Solution {
    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        return numbers;
    }
}