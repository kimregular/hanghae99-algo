package p1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }
    
    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private List<List<Integer>> readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(tokens[0]);
        int numOfLinks = Integer.parseInt(tokens[1]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < numOfLinks; i++) {
            tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            result.get(from).add(to);
        }
        return result;
    }
}

class Solution {

    public String solution(List<List<Integer>> graph) {
        StringBuilder answer = new StringBuilder();
        int[] indegree = getIndegree(graph);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            answer.append(cur).append(" ");

            for (Integer next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
        return answer.toString();
    }

    private int[] getIndegree(List<List<Integer>> graph) {
        int len = graph.size();
        int[] indegree = new int[len];
        for (int i = 1; i < len; i++) {
            List<Integer> node = graph.get(i);
            for (Integer next : node) {
                indegree[next]++;
            }
        }
        return indegree;
    }
}