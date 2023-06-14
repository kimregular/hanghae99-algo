package Rmy_String;

public class Main {
    public static void main(String[] args) {

        String str = "ssss";

        Solution s = new Solution();
        System.out.println(s.solution(str));
    }
}


class Solution {

    public String solution(String str) {
        return str.replaceAll("m", "rn");
    }
}