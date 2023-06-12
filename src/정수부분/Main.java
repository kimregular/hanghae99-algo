package 정수부분;

public class Main {
    public static void main(String[] args) {

        double flo = 3.14;

        Solution s = new Solution();
        System.out.println(s.solution(flo));
    }
}

class Solution {
    public int solution(double flo) {
        return (int) flo;
    }
}
