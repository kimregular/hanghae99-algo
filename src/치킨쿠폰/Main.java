package 치킨쿠폰;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int chicken = 1999;
        System.out.println(s.solution(chicken));
    }
}

class Solution {
    public int solution(int chicken) {
        int answer = 0;

        while (chicken >= 10) {
            answer += chicken / 10;
            chicken = chicken / 10 + chicken % 10;
        }
        return answer;
    }
}