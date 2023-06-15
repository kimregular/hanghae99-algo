package 정수찾기;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr = {1, 2, 3, 4, 5};
        int n = 3;

        System.out.println(s.solution(arr, n));
    }
}

class Solution {
    public int solution(int[] arr, int n) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                flag = true;
                break;
            }
        }

        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }
}
