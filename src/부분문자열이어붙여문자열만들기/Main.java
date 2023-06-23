package 부분문자열이어붙여문자열만들기;

public class Main {
    public static void main(String[] args) {

        String[] str1 = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] arr = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};

        Solution s = new Solution();
        System.out.println(s.solution(str1, arr));
    }
}

class Solution {

    public String solution(String[] str1, int[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str1.length; i++) {
            String tmp = str1[i];
            int num1 = arr[i][0];
            int num2 = arr[i][1];

            String part = tmp.substring(num1, num2+1);
            sb.append(part);
        }
        return sb.toString();
    }
}
