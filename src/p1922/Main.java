package p1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfComputers, ip.wires));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int numOfComputers = Integer.parseInt(br.readLine());
        int numOfWires = Integer.parseInt(br.readLine());

        int[][] wires = new int[numOfWires][3];
        for (int i = 0; i < numOfWires; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            wires[i][0] = from;
            wires[i][1] = to;
            wires[i][2] = cost;
        }
        return new Input(numOfComputers, wires);
    }

    private static class Input{
        private final int numOfComputers;
        private final int[][] wires;

        public Input(int numOfComputers, int[][] wires) {
            this.numOfComputers = numOfComputers;
            this.wires = wires;
        }
    }
}

class Solution {

    public int solution(int numOfComputers, int[][] wires) {
        Arrays.sort(wires, Comparator.comparing(a -> a[2]));
        int[] group = initGroup(numOfComputers);

        int cnt = 0;
        int sumOfCosts = 0;

        for (int[] wire : wires) {
            if(cnt == numOfComputers - 1) break;
            int from = wire[0];
            int to = wire[1];
            if(isSameGroup(group, from, to)) continue;

            connect(group, from, to);
            sumOfCosts += wire[2];
        }

        return sumOfCosts;
    }

    private int[] initGroup(int numOfComputers) {
        int[] result = new int[numOfComputers + 1];
        for (int i = 0; i < numOfComputers + 1; i++) {
            result[i] = i;
        }
        return result;
    }

    private boolean isSameGroup(int[] group, int target1, int target2) {
        return getGroup(group, target1) == getGroup(group, target2);
    }

    private int getGroup(int[] group, int target) {
        if(target != group[target]) group[target] = getGroup(group, group[target]);
        return group[target];
    }

    private void connect(int[] group, int target1, int target2) {
        int group1 = getGroup(group, target1);
        int group2 = getGroup(group, target2);
        group[Math.max(group1, group2)] = Math.min(group1, group2);
    }
}