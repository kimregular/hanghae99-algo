package A강조하기;

import javax.print.attribute.ResolutionSyntax;

public class Main {
    public static void main(String[] args) {

        String str = "PrOgRaMmErS";
        Solution s = new Solution();

        System.out.println(s.solution(str));
    }
}


class Solution {
    public String solution(String str) {
        return str.toLowerCase().replaceAll("a", "A");
    }
}