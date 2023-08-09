package 배열만들기6;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}


class Solution {

    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        int i = 0;
        while (i < arr.length) {
            if (stk.isEmpty() || stk.peek() != arr[i]) {
                stk.push(arr[i]);
                i++;
            } else if (stk.peek() == arr[i]) {
                stk.pop();
                i++;
            }
        }
        if (stk.isEmpty()) {
            return new int[]{-1};
        }

        return stk.stream().mapToInt(a -> a).toArray();
    }
}