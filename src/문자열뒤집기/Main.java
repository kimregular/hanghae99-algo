package 문자열뒤집기;

public class Main {
    public static void main(String[] args) {
        String str = "Progra21Sremm3";
        int a = 6;
        int b = 12;

        Solution s = new Solution();
        System.out.println(s.solution(str, a, b));;
    }
}


class Solution {

    public String solution(String str, int a, int b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a; i++) {
            sb.append(str.charAt(i));
        }

        for (int i = b; i >= a; i--) {
            sb.append(str.charAt(i));
        }

        for (int i = b+1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}