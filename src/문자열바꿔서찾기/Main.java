package 문자열바꿔서찾기;

public class Main {
    public static void main(String[] args) {

        String str = "ABBAA";
        String pat = "AABB";

        Solution s = new Solution();
        System.out.println(s.solution(str, pat));

    }
}

class Solution {
    public int solution(String str, String pat) {
        String newStr = changeLetter(str);

        if (newStr.contains(pat)) {
            return 1;
        } else {
            return 0;
        }

    }

    protected String changeLetter(String string) {
        return string.replaceAll("A", "T").replaceAll("B", "A").replaceAll("T", "B");
    }
}