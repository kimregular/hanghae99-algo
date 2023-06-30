package 콜라츠수열만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int n = 10;

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n)));

    }
}

class Solution {

    public int[] solution(int num) {
        List<Integer> answer = new ArrayList<>();
        answer.add(num);
        while (answer.get(answer.size()-1) != 1) {
            int tmp = answer.get(answer.size() - 1);
            if (tmp % 2 == 0) {
                answer.add(tmp / 2);
            } else {
                answer.add(3 * tmp + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

