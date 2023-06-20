package 이어붙인수;

public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 2, 1};

        Solution s = new Solution();
        System.out.println(s.solution(arr));

    }
}

class Solution {

    public int solution(int[] arr) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i : arr) {
            if (isEven(i)) {
                even.append(i);
            } else {
                odd.append(i);
            }
        }


        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }

    protected boolean isEven(int n) {
        return n % 2 == 0;
    }

}
