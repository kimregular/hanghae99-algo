package 문자열로변환;

public class Main {
    public static void main(String[] args) {

        int num = 10;

        Solution s = new Solution();
        System.out.println(s.solution(num));

    }
}

class Solution {

    public String solution(int num) {
        return String.valueOf(num);
    }
}
