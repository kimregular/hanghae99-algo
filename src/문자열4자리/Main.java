package 문자열4자리;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("a234"));



    }

    static class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            if (!(s.length() == 4 || s.length() == 6)) {
                return false;
            }
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] > '9' || chs[i] < '0') {
                    answer = false;
                    break;
                }
            }
            return answer;
        }
    }
}
