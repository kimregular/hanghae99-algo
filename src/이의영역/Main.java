package 이의영역;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 10, 2};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {

    public int[] solution(int[] arr) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                start = i;
                break;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                end = i;
                break;
            }
        }

        if (end == 0) {
            return new int[]{-1};
        } else if (start == end) {
            return new int[]{2};
        }

        int[] answer = new int[end - start + 1];

        int idx = 0;
        for (int i = start; i < end + 1; i++) {
            answer[idx++] = arr[i];
        }

        return answer;

    }
}
