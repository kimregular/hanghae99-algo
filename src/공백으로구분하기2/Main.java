package 공백으로구분하기2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String str = " i  love you";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));
    }
}


class Solution {

    public String[] solution(String str) {
        return str.strip().replaceAll("\\s+", " ").split(" ");
    }
}