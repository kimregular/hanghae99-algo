package 모의고사;


import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(s.solution(answers)));
    }
}

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};

        int num1S = 0, num2S = 0, num3S = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i%num1.length]) {
                num1S++;
            }
            if (answers[i] == num2[i%num2.length]) {
                num2S++;
            }
            if (answers[i] == num3[i%num3.length]) {
                num3S++;
            }
        }
        int max = Math.max(num1S, Math.max(num2S, num3S));
        if (max == 0) {
            return answer.stream().mapToInt(i -> i).toArray();
        }
        if (max == num1S) {
            answer.add(1);
        }
        if (max == num2S) {
            answer.add(2);
        }
        if (max == num3S) {
            answer.add(3);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}


// 1,2,3,4,5
// 2,1,2,3,2,4,2,5
// 3,3,1,1,2,2,4,4,5,5