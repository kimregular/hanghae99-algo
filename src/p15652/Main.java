package p15652;

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

    public String solution(int n, int m) {
        CombinationMaker pm = new CombinationMaker(n, m);
        return pm.getResult();
    }

    class CombinationMaker {

        int n;
        int m;

        int[] combination;

        StringBuilder result = new StringBuilder();

        public CombinationMaker(int n, int m) {
            this.n = n;
            this.m = m;
            this.combination = new int[m];
        }

        public String getResult() {
            repeatedCombinate(0, 1);
            return this.result.toString();
        }

        void repeatedCombinate(int cnt, int start) {
            if (cnt == this.m) {
                saveCombination(this.combination);
                return;
            }

            for (int i = start; i <= this.n; i++) {
                this.combination[cnt] = i;
                repeatedCombinate(cnt + 1, i);
            }
        }

        void saveCombination(int[] combination) {
            for (int i : combination) {
                this.result.append(i).append(" ");
            }
            this.result.append("\n");
        }
    }
}
