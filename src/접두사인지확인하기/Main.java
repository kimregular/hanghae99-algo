package 접두사인지확인하기;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        String str = "banana";
        String isPrefix = "nan";

        System.out.println(s.solution(str, isPrefix));
    }
}

class Solution {

    public int solution(String str, String isPrefix) {
        int len = isPrefix.length();
        if (str.length() < len) {
            return 0;
        } else {
            String tmp = str.substring(0, len);
            if (tmp.equals(isPrefix)) {
                return 1;
            }
        }

        return 0;
    }
}
