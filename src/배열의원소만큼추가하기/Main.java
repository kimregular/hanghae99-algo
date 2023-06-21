package 배열의원소만큼추가하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 1, 4};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {

    public int[] solution(int[] arr) {
        int len = 0;
        for (int i : arr) {
            len += i;
        }

        int[] answer = new int[len];

        int idx = 0;
        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                answer[idx++] = i;
            }
        }

        return answer;
    }
}
