package 두수뽑아더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AddEveryTwoNums {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,1,3,4,1};
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>(numbers.length);
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = numbers[j] + numbers[i];
                for (int x = 0; x < numbers.length; x++) {
                    if(!answer.contains(tmp)){
                        answer.add(tmp);
                    }
                }

            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.stream().mapToInt(i -> i).toArray();
    }
}