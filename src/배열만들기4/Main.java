package 배열만들기4;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));

    }
}

class Solution {

    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        int i = 0;
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.push(arr[i]);
                i++;
            } else if (stk.peek() < arr[i]) {
                stk.push(arr[i]);
                i++;
            } else {
                stk.pop();
            }
        }

        return stk.stream().mapToInt(a -> a).toArray();
    }
}
