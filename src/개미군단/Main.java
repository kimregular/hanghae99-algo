package 개미군단;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int hp = 23;
        System.out.println(s.solution(hp));

    }
}


class Solution {
    public int solution(int hp) {
        int[] ants = {5, 3, 1};
        int answer = 0;
        for (int ant : ants) {
            answer += hp / ant;
            hp %= ant;
        }
        return answer;
    }
}