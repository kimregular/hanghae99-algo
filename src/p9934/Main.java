package p9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.k, ip.nodes));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new Input(k, nodes);
    }

    private static class Input {

        int k;
        int[] nodes;

        public Input(int k, int[] nodes) {
            this.k = k;
            this.nodes = nodes;
        }
    }
}

class Solution {

    public String solution(int k, int[] nodes) {
        Calculator c = new Calculator(k, nodes);
        return c.getResult();
    }
}

class Calculator {

    int k;
    int[] nodes;
    List<List<Integer>> tree = new ArrayList<>();
    StringBuilder result = new StringBuilder();

    public Calculator(int k, int[] nodes) {
        this.k = k;
        for (int i = 0; i < k; i++) {
            tree.add(new ArrayList<>());
        }
        this.nodes = nodes;
    }

    public String getResult() {
        explore(0, nodes.length - 1, 0);
        for (List<Integer> list : tree) {
            for (Integer i : list) {
                result.append(i).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void explore(int start, int end, int depth) {
        if(depth == k) return;

        int mid = (end + start) / 2;
        tree.get(depth).add(nodes[mid]);
        explore(start, mid, depth + 1);
        explore(mid + 1, end, depth + 1);
    }
}
