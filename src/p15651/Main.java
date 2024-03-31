package p15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.n, ip.m));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws  IOException {
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        return new Input(n, m);
    }

    static class Input {

        int n;
        int m;

        public Input(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}

class Solution {

    public String solution(int n, int m) {
        PermutationMaker pm = new PermutationMaker(n, m);
        return pm.getResult();
    }

    class PermutationMaker {

        int n;
        int m;
        int[] permutated;
        boolean[] isUsed;

        StringBuilder result = new StringBuilder();

        public PermutationMaker(int n, int m) {
            this.n = n;
            this.m = m;
            this.permutated = new int[m];
            this.isUsed = new boolean[n + 1];
        }

        public String getResult() {
            product(0);
            return this.result.toString();
        }

        void product(int cnt) {
            if (cnt == this.m) {
                savePermutated(this.permutated);
                return;
            }

            for (int i = 1; i <= this.n; i++) {
                this.permutated[cnt] = i;
                product(cnt + 1);
            }
        }

        void savePermutated(int[] permutated) {
            for (int i : permutated) {
                this.result.append(i).append(" ");
            }
            result.append("\n");
        }
    }
}