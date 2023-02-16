package 약수의개수와덧셈;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int left = 13;
        int right = 17;
        System.out.println(s.solution(left, right));

    }
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int num = 0;
        int cnt = 0;
        for (int i = left; i < right+1; i++) {
            num = i;
            for (int j = 1; j < num+1; j++) {
                if (num % j == 0) {
                    cnt++;
                }
            }

            if (cnt % 2 == 0) {
                answer += num;
            } else {
                answer -= num;
            }
            cnt = 0;
        }
        return answer;
    }
}