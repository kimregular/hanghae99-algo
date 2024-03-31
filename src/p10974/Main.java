package p10974;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            s.solution(getInput(br));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public void solution(int num) {
        PermutationMaker pm = new PermutationMaker(num);
        pm.permutate(0);
    }

    private class PermutationMaker{

        int n;
        int[] permutated;
        boolean[] isUsed;

        PermutationMaker(int n){
            this.n = n;
            this.permutated = new int[n];
            this.isUsed = new boolean[n + 1];
        }

        void permutate(int cnt){
            if(cnt == this.n){
                printPermutated(this.permutated);
                return;
            }

            for (int i = 1; i <= this.n; i++) {
                if(this.isUsed[i]) continue;

                this.isUsed[i] = true;
                this.permutated[cnt] = i;
                permutate(cnt + 1);
                this.isUsed[i] = false;
            }
        }

        private void printPermutated(int[] permutated) {
            for (int i : permutated) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
