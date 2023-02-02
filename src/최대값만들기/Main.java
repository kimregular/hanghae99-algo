package 최대값만들기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1, -2};
        System.out.println(s.solution(numbers));

    }
}


class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max = -123123123;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] * numbers[j] > max) {
                    max = numbers[i] * numbers[j];
                }
            }
        }
        answer = max;
        return answer;
    }
}

/*
numbers
[1, -2]
result
-2
 */