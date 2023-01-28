package 수박수박;

public class SooParkSooPark {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.solution(4));
    }
}

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                answer.append("박");
            } else {
                answer.append("수");
            }
        }
        return answer.toString();
    }
}
