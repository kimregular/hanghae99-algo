package 게임369;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int order = 3;
        System.out.println(s.solution(order));

    }
}


class Solution {
    public int solution(int order) {
        int answer = 0;
        while (order > 0) {
            int tmp = order % 10;
            order /= 10;
            if (tmp == 3 || tmp == 6 || tmp == 9) {
                answer++;
            }
        }
        return answer;
    }
}