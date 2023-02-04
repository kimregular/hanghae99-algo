package 이진수더하기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String bin1 = "10";
        String bin2 = "11";
        System.out.println(s.solution(bin1, bin2));

    }
}


class Solution {
    public String solution(String bin1, String bin2) {
        int bbin1 = Integer.parseInt(bin1, 2);
        int bbin2 = Integer.parseInt(bin2, 2);
        int tmp = bbin1 + bbin2;
        return Integer.toString(tmp, 2);
    }
}