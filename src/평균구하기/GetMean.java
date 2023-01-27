package 평균구하기;

public class GetMean {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5,5};
        System.out.println(s.solution(arr));
    }
}

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int num : arr) {
            answer += num;
        }
        return answer / arr.length;
    }
}
