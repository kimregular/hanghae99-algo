package 가까운1찾기;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 0, 0, 1};
        int idx = 1;

        Solution s = new Solution();
        System.out.println(s.solution(arr, idx));
    }
}

class Solution {

    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}
