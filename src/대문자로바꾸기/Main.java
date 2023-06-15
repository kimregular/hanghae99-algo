package 대문자로바꾸기;

public class Main {
    public static void main(String[] args) {

        String str = "aBcDeFg";
        Solution s = new Solution();
        System.out.println(s.solution(str));

    }
}

class Solution {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'a' && tmp <= 'z') {
                tmp -= 32;
            }
            sb.append(tmp);
        }

        return sb.toString();
    }
}