package p2992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public int solution(int target) {
        PermutationResolver pr = new PermutationResolver(target, getArray(target));
        return pr.getResult();
    }

    private int[] getArray(int target) {
        String tempNum = String.valueOf(target);
        int[] result = new int[tempNum.length()];

        for (int i = 0; i < tempNum.length(); i++) {
            result[i] = tempNum.charAt(i) - '0';
        }

        Arrays.sort(result);

        return result;
    }

    private class PermutationResolver {

        int target;
        int[] group;
        int select;
        int[] permutated;
        boolean[] isUsed;

        int result = Integer.MAX_VALUE;

        public PermutationResolver(int target, int[] group) {
            this.target = target;
            this.group = group;
            this.select = group.length;
            this.permutated = new int[select];
            this.isUsed = new boolean[group.length];
        }

        public int getResult() {
            permutate(0);
            return this.result == Integer.MAX_VALUE ? 0 : this.result;
        }

        private void permutate(int cnt) {
            if (cnt == this.select) {
                checkValue();
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

        private void checkValue() {
            int value = getArrayToNum();
            if (this.target < value) {
                this.result = Math.min(this.result, value);
            }
        }

        private int getArrayToNum() {
            int result = 0;
            for (int i : this.permutated) {
                result *= 10;
                result += i;
            }
            return result;
        }
    }
}