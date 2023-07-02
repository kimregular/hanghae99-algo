package 코드처리하기;

public class Main {
    public static void main(String[] args) {

        String code = "abc1abc1abc";
        Solution s = new Solution();
        System.out.println(s.solution(code));
    }
}

class Solution {

    public String solution(String code) {
        boolean mode = true; // mode : 0

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char tmp = code.charAt(i);

            if (tmp == '1') {
                mode = !mode;
                continue;
            }

            if (mode) {
                if (i % 2 == 0) {
                    sb.append(tmp);
                }
            } else {
                if (i % 2 != 0) {
                    sb.append(tmp);
                }
            }
        }

        return sb.length() > 0 ? sb.toString() : "EMPTY";
    }

}
