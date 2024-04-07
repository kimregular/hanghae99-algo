package p18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.gain, ip.weightLoss));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int weightloss = Integer.parseInt(st.nextToken());

        int[] gain = new int[len];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < gain.length; i++) {
            gain[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(gain, weightloss);
    }

    private static class Input {

        int[] gain;
        int weightLoss;

        public Input(int[] gain, int weightLoss) {
            this.gain = gain;
            this.weightLoss = weightLoss;
        }
    }
}

class Solution {

    public int solution(int[] gain, int weightloss) {
        PermutationResolver pr = new PermutationResolver(gain, weightloss);
        return pr.getResult();
    }

    private class PermutationResolver {

        int[] group;
        int weightloss;
        int[] permutated;
        boolean[] isUsed;
        int result = 0;

        public PermutationResolver(int[] group, int weightloss) {
            this.group = group;
            this.weightloss = weightloss;
            this.permutated = new int[this.group.length];
            this.isUsed = new boolean[this.group.length];
        }

        public int getResult() {
            permutate(0);
            return this.result;
        }

        private void permutate(int cnt) {
            if (cnt == this.group.length) {
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
            int weight = 500;
            boolean isGood = true;
            for (int i : this.permutated) {
                weight += i;
                weight -= this.weightloss;
                if (weight < 500) {
                    isGood = false;
                    break;
                }
            }
            if(isGood) this.result++;
        }
    }
}
