package 문자열이몇번등장하는지세기;

public class Main {
    public static void main(String[] args) {

        String str = "banana";
        String pat = "ana";
        Solution s = new Solution();
        System.out.println(s.solution(str, pat));

    }
}

class Solution {

    public int solution(String str, String pat) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - pat.length() + 1; i++) {
            for (int j = i; j < i + pat.length(); j++) {
                sb.append(str.charAt(j));
            }
            System.out.println(sb.toString());
            if (sb.toString().equals(pat)) {
                cnt++;
            }
            sb.setLength(0);
        }

        return cnt;
    }
}
