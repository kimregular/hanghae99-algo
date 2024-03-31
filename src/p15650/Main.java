package p15650;

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
        CombinationMaker cm = new CombinationMaker(n, m);
        cm.combinate(0, 1);
    }

    class CombinationMaker {

        int n;
        int m;
        int[] combination;

        CombinationMaker(int n, int m) {
            this.n = n;
            this.m = m;
            this.combination = new int[m];
        }

        void combinate(int cnt, int start) {
            if (cnt == this.m) {
                printCombination(this.combination);
                return;
            }
            for (int i = start; i <= this.n; i++) {
                this.combination[cnt] = i;
                combinate(cnt + 1, i + 1);
            }
        }

        void printCombination(int[] combination) {
            for (int i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}