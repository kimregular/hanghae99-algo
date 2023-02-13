package 종이자르기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int M = 1;
        int N = 1;
        System.out.println(s.solution(M, N));
    }
}

class Solution {
    public int solution(int M, int N) {
        int verti = Math.min(M, N);
        int hori = Math.max(M, N);

        return (verti-1) + verti*(hori-1);
    }
}


