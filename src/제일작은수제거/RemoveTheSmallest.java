package 제일작은수제거;


import java.util.ArrayList;
import java.util.Arrays;

public class RemoveTheSmallest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,3,2,1,1,1,2};
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int tmp = 123123123;

        for (int num : arr) {
            if (num < tmp) {
                tmp = num;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > tmp) {
                arrList.add(arr[i]);
            }
        }
        if (arrList.size() == 0) {
            arrList.add(-1);
        }
        int[] answer = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }


        return answer;
    }
}
