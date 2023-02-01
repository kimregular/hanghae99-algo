package 주사위개수;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] box = {10, 8, 6};
        int n = 3;
        System.out.println(s.solution(box, n));
    }
}

class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        int[] tmp = new int[3];
        for (int i = 0; i < box.length; i++) {
            tmp[i] = box[i] / n;
        }
        for (int num : tmp) {
            answer *= num;
        }
        return answer;
    }
}