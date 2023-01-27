package 음양더하기;

public class AddBySigns {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] absolutes = new int[]{1,2,3};
        boolean[] signs = new boolean[]{false,false,true};
        System.out.println(s.solution(absolutes, signs));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int cur = 0;
        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                answer += absolutes[cur];
                cur++;
            } else {
                answer -= absolutes[cur];
                cur++;
            }
        }
        return answer;
    }
}
