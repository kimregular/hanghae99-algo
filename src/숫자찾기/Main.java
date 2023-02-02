package 숫자찾기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 232443;
        int k = 4;
        System.out.println(s.solution(num, k));

    }
}

class Solution {
    public int solution(int num, int k) {
        int answer = 0;

        answer = String.valueOf(num).indexOf(k +"") + 1;


        return answer != 0 ? answer : -1;
    }
}