package 다음에올숫자;


public class Main {
    public static void main(String[] args) {

        int[] common = {2,4,8};

        Solution s = new Solution();
        System.out.println(s.solution(common));

    }
}

class Solution {

    public int solution(int[] common) {
        int answer = 0;

        if (isGeomatricSequence(common)) {
            answer = getDifference(common);
        } else {
            answer = getRatio(common);
        }

        return answer;
    }

    private boolean isGeomatricSequence(int[] common) {
        int[] differs = new int[2];
        for (int i = 0; i < 2; i++) {
            differs[i] = Math.abs(common[i] - common[i + 1]);
        }
        if (differs[0] == differs[1]) {
            return true;
        }
        return false;
    }

    private int getDifference(int[] common) {
        return common[common.length - 1] +  common[common.length - 1] - common[common.length - 2];
    } // token regenerated

    private int getRatio(int[] common) {
        return common[common.length - 1] * (common[1] / common[0]);
    }
}