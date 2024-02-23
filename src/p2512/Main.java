package p2512;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.requires, ip.budget));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int numOfRequires = Integer.parseInt(br.readLine());

        int[] requires = new int[numOfRequires];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < requires.length; i++) {
            requires[i] = Integer.parseInt(st.nextToken());
        }

        int budget = Integer.parseInt(br.readLine());

        return new Input(requires, budget);
    }
}

class Solution {

    public long solution(int[] requires, int budget) {
        Calculator cl = new Calculator(requires, budget);
        return cl.getMaxDisposableBudget();
    }

    class Calculator {

        int[] requires;
        int budget;

        public Calculator(int[] requires, int budget) {
            this.requires = requires;
            this.budget = budget;
        }

        public long getMaxDisposableBudget() {
            long lp = 1;
            long rp = getSumOfRequires();

            if(rp <= this.budget) return getMaxRequire();

            while (lp + 1 < rp) {

                long point = (lp + rp) / 2;

                long evenDistribution = getEvenDistribution(point);

                if(evenDistribution > this.budget) rp = point;
                else lp = point;
            }

            return lp;
        }

        private long getEvenDistribution(long point) {
            long evenDistribution = 0;

            for (int require : this.requires) {
                evenDistribution += Math.min(require, point);
            }

            return evenDistribution;
        }

        private long getSumOfRequires() {
            long sumOfRequires = 0;

            for (int require : this.requires) {
                sumOfRequires += require;
            }

            return sumOfRequires;
        }

        private int getMaxRequire() {
            int maxRequire = 0;
            for (int require : this.requires) {
                if(require > maxRequire) maxRequire = require;
            }

            return maxRequire;
        }
    }
}
class Input {

    int[] requires;
    int budget;

    public Input(int[] requires, int budget) {
        this.requires = requires;
        this.budget = budget;
    }
}
