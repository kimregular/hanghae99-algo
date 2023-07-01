package 일로만들기;

public class Main {
    public static void main(String[] args) {

        int[] arr = {12, 4, 15, 1, 14};

        Solution s = new Solution();
        System.out.println(s.solution(arr));
    }
}


class Solution {

    public int solution(int[] arr) {
        int result = 0;

        for (int i : arr) {
            int tmp = 0;
            while (i != 1) {
                if (i % 2 == 0) {
                    i /= 2;
                } else {
                    i -= 1;
                    i /= 2;
                }
                tmp++;
            }
            result += tmp;
        }

        return result;
    }
}