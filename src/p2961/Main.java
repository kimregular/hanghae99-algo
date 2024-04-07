package p2961;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        int[][] stuff = new int[len][2];

        for (int i = 0; i < stuff.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int sour = Integer.parseInt(tokens[0]);
            int bitter = Integer.parseInt(tokens[1]);
            stuff[i][0] = sour;
            stuff[i][1] = bitter;
        }
        return stuff;
    }
}

class Solution {

    public int solution(int[][] stuff) {
        CombinationResolver cr = new CombinationResolver(stuff);
        return cr.getResult();
    }

    private class CombinationResolver{

        int[][] stuff;
        int[] combinated;

        int result = Integer.MAX_VALUE;

        public CombinationResolver(int[][] stuff){
            this.stuff = stuff;
        }

        public int getResult(){
            for(int i = 1; i <= this.stuff.length; i++){
                this.combinated = new int[i];
                combinate(0, 0);
            }
            return this.result;
        }

        private void combinate(int cnt, int start) {
            if (cnt == this.combinated.length) {
                saveCombinated();
                return;
            }

            for (int i = start; i < this.stuff.length; i++) {
                this.combinated[cnt] = i;
                combinate(cnt + 1, i + 1);
            }
        }

        private void saveCombinated() {
            int sour = 1;
            int bitter = 0;

            for (int idx : this.combinated) {
                int sourness = this.stuff[idx][0];
                int bitterness = this.stuff[idx][1];

                sour *= sourness;
                bitter += bitterness;
            }

            this.result = Math.min(this.result, Math.abs(sour - bitter));
        }
    }
}
