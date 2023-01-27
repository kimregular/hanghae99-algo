package 없는숫자더하기;

public class AddAbsentNums {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,3,4,6,7,8,0};
        System.out.println(s.solution(arr));
    }
}

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int num : numbers) {
            answer -= num;
        }
        return answer;
    }
}
