package n개간격의원소들;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] arr = {4, 2, 6, 1, 7, 6};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, 2)));
    }
}


class Solution {
    public int[] solution(int[] arr, int n) {
        int len = (arr.length - 1) / n;
        int[] answer = new int[len+1];

        int idx = 0;
        for (int i = 0; i < arr.length; i += n) {
            answer[idx++] = arr[i];
        }

        return answer;
    }
}