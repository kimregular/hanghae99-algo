package 수조작하기2;

public class Main {
    public static void main(String[] args) {

        int[] log = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};

        Solution s = new Solution();
        System.out.println(s.solution(log));
    }
}

class Solution {

    public String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        int cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (cur < arr[i]) {
                // 1 큰 경우
                if (cur + 1 == arr[i]) {
                    sb.append("w");
                } else {
                    sb.append("d");
                }
                // 10 큰 경우
            } else {
                // 1 작은 경우
                if (cur - 1 == arr[i]) {
                    sb.append("s");
                } else {
                    sb.append("a");
                }
                // 10 작은 경우
            }
            cur = arr[i];
        }
        return sb.toString();
    }
}