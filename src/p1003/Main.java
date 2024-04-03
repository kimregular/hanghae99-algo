package p1003;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public String solution(int target) {
        FiboResolver fr = new FiboResolver(target);
        return fr.getResult();
    }

    private class FiboResolver {

        int target;
        int[][] fiboArr;

        public FiboResolver(int target) {
            this.target = target;
            this.fiboArr = new int[target + 1][2];

        }

        public String getResult() {
            fillFiboArr();
            int zeroCallNum = this.fiboArr[target][0];
            int oneCallNum = this.fiboArr[target][1];

            return zeroCallNum + " " + oneCallNum;
        }

        private void fillFiboArr() {

            if (this.target == 0) {
                this.fiboArr[0] = new int[]{1, 0};
                return;
            } else if (this.target == 1) {
                this.fiboArr[0] = new int[]{1, 0};
                this.fiboArr[1] = new int[]{0, 1};
                return;
            }

            this.fiboArr[0] = new int[]{1, 0};
            this.fiboArr[1] = new int[]{0, 1};

            for (int i = 2; i < this.fiboArr.length; i++) {
                this.fiboArr[i][0] = this.fiboArr[i - 1][0] + this.fiboArr[i - 2][0];
                this.fiboArr[i][1] = this.fiboArr[i - 1][1] + this.fiboArr[i - 2][1];
            }
        }
    }

}