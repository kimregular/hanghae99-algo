package 삼각형의완성조건;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] sides = {3,6};
        System.out.println(s.solution(sides));

    }
}

class Solution {
    public int solution(int[] sides) {

        Arrays.sort(sides);
        int start = sides[1] - sides[0] + 1;
        int end = sides[1] + sides[0];
        return end - start;
    }
}