package 영때기;

public class Main {
    public static void main(String[] args) {


        String str = "854020";

        Solution s = new Solution();
        System.out.println(s.solution(str));
    }
}


class Solution {

    public String solution(String str) {
        int tmp = Integer.parseInt(str);
        return String.valueOf(tmp);
    }
}