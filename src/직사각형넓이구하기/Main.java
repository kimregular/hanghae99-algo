package 직사각형넓이구하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] dots = {{1,1}, {2,1}, {2,2}, {1,2}};
        System.out.println(s.solution(dots));

    }
}

class Solution {
    public int solution(int[][] dots) {

        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] > xMax) {
                xMax = dots[i][0];
            }
            if (dots[i][0] < xMin) {
                xMin = dots[i][0];
            }
        }

        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][1] > yMax) {
                yMax = dots[i][1];
            }
            if (dots[i][1] < yMin) {
                yMin = dots[i][1];
            }
        }

        return (xMax - xMin) * (yMax - yMin);
    }
}