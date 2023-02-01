package 인덱스바꾸기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String my_string = "hello";
        int num1 = 1;
        int num2 = 2;
        System.out.println(s.solution(my_string, num1, num2));

    }
}

class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder answer = new StringBuilder();
        char[] arr = my_string.toCharArray();
        char tmp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = tmp;
        for (char ch : arr) {
            answer.append(ch);
        }
        return answer.toString();
    }
}