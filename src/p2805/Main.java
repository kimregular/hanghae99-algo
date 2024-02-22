package p2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);

            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.trees));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] params = br.readLine().split(" ");

        int numOfTrees = Integer.parseInt(params[0]);
        int target = Integer.parseInt(params[1]);

        int[] trees = new int[numOfTrees];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        return new Input(target, trees);
    }
}

class Solution {

    public long solution(int target, int[] trees) {
        Calculator cl = new Calculator(target, trees);
        return cl.calc();
    }

    class Calculator {

        int target;
        int[] trees;
        long tallestTree;

        public Calculator(int target, int[] trees) {
            this.target = target;
            this.trees = trees;
            this.tallestTree = getTallestTree(trees);
        }

        public long calc() {
            long lp = 0;
            long rp = this.tallestTree;

            while (lp + 1 < rp) {
                long point = (lp + rp) / 2;

                long lengthOfWoods = getLengthOfWoods(point);

                if(lengthOfWoods >= this.target) lp = point;
                else rp = point;
            }

            return lp;
        }

        private long getLengthOfWoods(long point) {
            long lengthOfWoods = 0;

            for (long tree : this.trees) {
                if(tree > point) lengthOfWoods += tree - point;
            }

            return lengthOfWoods;
        }

        private long getTallestTree(int[] trees) {
            long tallestTree = 0;

            for (long tree : trees) {
                if (tree > tallestTree) tallestTree = tree;
            }

            return tallestTree;
        }
    }


}

class Input {

    int target;
    int[] trees;

    public Input(int target, int[] trees) {
        this.target = target;
        this.trees = trees;
    }
}
