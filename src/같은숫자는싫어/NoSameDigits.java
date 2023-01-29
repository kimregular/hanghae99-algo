package 같은숫자는싫어;


import java.util.ArrayList;
import java.util.Arrays;

public class NoSameDigits {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int num : arr) {
            if (answer.get(answer.size()-1) != num) {
                answer.add(num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}