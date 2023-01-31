package 삼각형의완성조건1;

//https://school.programmers.co.kr/learn/courses/30/lessons/120889
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] sides = {1,2,3};
        System.out.println(s.solution(sides));
    }
}

class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < sides.length; i++) {
            if (sides[i] > max) {
                max = sides[i];
            }
            sum += sides[i];
        }

        return (sum - max > max) ? 1: 2;
    }
}