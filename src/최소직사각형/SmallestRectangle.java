package 최소직사각형;


import java.util.ArrayList;
import java.util.Comparator;

public class SmallestRectangle {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] sizes = {{60,50}, {30,70}, {60, 30}, {80, 40}};
        int[][] sizes = {{3, 4}, {2, 1}};
//        int[][] sizes = {{91,50},{77,51}, {50,1}, {50,50}};
//        4641

        System.out.println(s.solution(sizes));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                arr1.add(size[0]);
                arr2.add(size[1]);
            } else {
                arr2.add(size[0]);
                arr1.add(size[1]);
            }
        }
        arr1.sort(Comparator.reverseOrder());
        arr2.sort(Comparator.reverseOrder());
        return arr1.get(0) * arr2.get(0);
    }
}