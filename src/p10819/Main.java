package p10819;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        int[] nums = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return nums;
    }
}

class Solution {

    public int solution(int[] nums) {
        PermutationResolver pr = new PermutationResolver(nums);
        return pr.getResult();
    }

    private class PermutationResolver {

        int[] group;
        int[] permutated;
        boolean[] isUsed;
        int result = Integer.MIN_VALUE;

        public PermutationResolver(int[] num) {
            Arrays.sort(num);
            this.group = num;
            this.permutated = new int[num.length];
            this.isUsed = new boolean[num.length];
        }

        public int getResult() {
            permutate(0);
            return this.result;
        }

        private void permutate(int cnt) {
            if (cnt == this.permutated.length) {
                savePermutated();
                return;
            }

            for (int i = 0; i < this.group.length; i++) {
                if(this.isUsed[i]) continue;

                this.isUsed[i] = true;
                this.permutated[cnt] = this.group[i];
                permutate(cnt + 1);
                this.isUsed[i] = false;
            }
        }

        private void savePermutated() {
            int score = 0;
            for (int i = 0; i < this.permutated.length - 1; i++) {
                score += Math.abs(this.permutated[i] - this.permutated[i + 1]);
            }

            this.result = Math.max(this.result, score);
        }
    }
}
