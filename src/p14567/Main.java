package p14567;

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
        int[] indegree = getIndegree(graph);
        int[] dp = new int[graph.size()];

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int semester = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                dp[cur] = semester;
                for (Integer next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.offer(next);
                }
            }
            semester++;
        }

        return getAnswer(dp);
    }

    private int[] getIndegree(List<List<Integer>> graph) {
        int[] indegree = new int[graph.size()];

        for (int i = 1; i < graph.size(); i++) {
            List<Integer> node = graph.get(i);
            for (Integer nextNode : node) {
                indegree[nextNode]++;
            }
        }
        return indegree;
    }

    private String getAnswer(int[] dp) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < dp.length; i++) {
            answer.append(dp[i]).append(" ");
        }
        return answer.toString();
    }
}