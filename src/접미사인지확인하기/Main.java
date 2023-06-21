package 접미사인지확인하기;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        String str = "banana";
        String isPrefix = "ana";

        System.out.println(s.solution(str, isPrefix));
    }
}

class Solution {

    public int solution(String str, String isSuffix) {
        if (str.endsWith(isSuffix)) {
            return 1;
        } else {
            return 0;
        }
    }
}
