package 중복된숫자개수;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1, 1, 2, 3, 4, 5};
        int n = 1;
        System.out.println(s.solution(array, n));
    }
}


class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int num : array) {
            if (n == num) {
                answer++;
            }
        }
        return answer;
    }
}