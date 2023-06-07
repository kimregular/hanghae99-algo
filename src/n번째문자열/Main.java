package n번째문자열;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "ProgrammerS123";
        int n = 11;

        System.out.println(s.solution(str ,n));

    }
}

class Solution {
    public String solution(String str, int n) {
        return str.substring(0, n);
    }
}
