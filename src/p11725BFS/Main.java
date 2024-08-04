package p11725BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < len - 1; i++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        return tree;
    }
}

class Solution {

    public String solution(List<List<Integer>> tree) {
        Calculator c = new Calculator(tree);
        return c.getResult();
    }
}

class Calculator {

    List<List<Integer>> tree;
    boolean[] isVisited;
    int[] parentOf;
    StringBuilder result = new StringBuilder();

    public Calculator(List<List<Integer>> tree) {
        this.tree = tree;
        this.isVisited = new boolean[tree.size()];
        this.parentOf = new int[tree.size()];
    }

    public String getResult() {
        explore();
        for (int i = 2; i < parentOf.length; i++) {
            result.append(parentOf[i]).append("\n");
        }
        return result.toString();
    }

    private void explore() {
        for (int startNode : tree.get(1)) {
            if(isVisited[startNode]) continue;
            findParent(startNode);
        }
    }

    private void findParent(int startNode) {
        isVisited[startNode] = true;
        parentOf[startNode] = 1;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startNode);

        while (!q.isEmpty()) {

            int parent = q.poll();

            for (int child : tree.get(parent)) {
                if(isVisited[child]) continue;
                isVisited[child] = true;
                parentOf[child] = parent;
                q.offer(child);
            }
        }
    }
}