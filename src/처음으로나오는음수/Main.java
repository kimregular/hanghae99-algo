package 처음으로나오는음수;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr = {12, 4, 15, 46, 38, -2, 15};
        System.out.println(s.solution(arr));

    }
}

class Solution {

    public int solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }

        return -1;
    }
}
