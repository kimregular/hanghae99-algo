package 마지막두원소;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 1, 6};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length + 1];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        int temp = arr[arr.length - 1];
        int com = arr[arr.length - 2];

        if (temp > com) {
            answer[answer.length - 1] = temp - com;
        } else {
            answer[answer.length - 1] = temp * 2;
        }

        return answer;
    }
}
