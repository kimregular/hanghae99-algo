package 리스트자르기;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int n = 1;
        int[] slicer = {1, 5, 2};
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n, slicer, num_list)));
    }
}

class Solution {

    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch (n) {
            case 1:
                return num1Cut(slicer, num_list);
            case 2:
                return num2Cut(slicer, num_list);
            case 3:
                return num3Cut(slicer, num_list);
            default:
                return num4Cut(slicer, num_list);
        }
    }

    private int[] num1Cut(int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, 0, slicer[1]+1);
    }

    private int[] num2Cut(int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
    }

    private int[] num3Cut(int[] slicer, int[] num_list) {
        return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
    }

    private int[] num4Cut(int[] slicer, int[] num_list) {
        List<Integer> answer = new ArrayList<>();

        for (int i = slicer[0]; i < slicer[1] + 1; i += slicer[2]) {
            answer.add(num_list[i]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}