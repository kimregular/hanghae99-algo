package 칠의개수;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {777};
        System.out.println(s.solution(array));
    }
}


class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int num : array) {
            answer += sevenCnt(num);
        }
        return answer;
    }

    public int sevenCnt(int num) {
        int cnt = 0;
        int tmp = 0;
        while (num > 0) {
            tmp = num % 10;
            if (tmp == 7) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
}