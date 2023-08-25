package 이진변환반복하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String str = "01110";

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(str)));
    }
}

class Solution {

    public int[] solution(String str) {
        int cnt = 0;
        int zeros = 0;

        while (!("1").equals(str)) {
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                }
            }

            str = str.replaceAll("0", "");
            str = Integer.toBinaryString(str.length());
            cnt++;
        }


        return new int[]{cnt, zeros};
    }
}
