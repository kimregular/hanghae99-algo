package p15649;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            s.solution(ip.n, ip.m);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
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

    public void solution(int n, int m) {
        PermutationMaker pm = new PermutationMaker(n, m);
        pm.permutate(0);
    }

    private class PermutationMaker {
        int n;
        int m;
        int[] permutated;
        boolean[] isUsed;

        PermutationMaker(int n, int m) {
            this.n = n;
            this.m = m;
            this.permutated = new int[m];
            this.isUsed = new boolean[n + 1];
        }

        void permutate(int cnt) {
            if (cnt == this.m) {
                printPermutated(this.permutated);
                return;
            }

            for (int i = 1; i <= n; i++) {
                if(this.isUsed[i]) continue;

                this.isUsed[i] = true;
                this.permutated[cnt] = i;
                permutate(cnt + 1);
                this.isUsed[i] = false;
            }
        }

        void printPermutated(int[] permutated) {
            for (int i : permutated) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
