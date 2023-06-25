package 배열의원소삭제하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arr = {293, 1000, 395, 678, 94};
        int[] deleteArr = {94, 777, 104, 1000, 1, 12};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr, deleteArr)));
    }
}

class Solution {

    public int[] solution(int[] arr, int[] deleteArr) {
        List<Integer> answer = new ArrayList<>();

        for (int tmp : arr) {
            boolean flag = true;
            for (int i : deleteArr) {
                if (tmp == i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer.add(tmp);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
