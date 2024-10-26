package p2623;

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
        int repeat = Integer.parseInt(tokens[1]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < repeat; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            int from = 0;
            int value = 0;
            while (st.hasMoreTokens()) {
                if (from == 0) {
                    from = Integer.parseInt(st.nextToken());
                    value = Integer.parseInt(st.nextToken());
                } else {
                    value = Integer.parseInt(st.nextToken());
                }
                result.get(from).add(value);
                from = value;
            }
        }
        return result;
    }
}

class Solution {

    public String solution(List<List<Integer>> graph) {
        StringBuilder answer = new StringBuilder();
        int[] indegree = getIndegree(graph);

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            answer.append(cur).append("\n");

            for (Integer next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }

        if (cnt == graph.size() - 1) {
            return answer.toString();
        }
        return "0";
    }

    private int[] getIndegree(List<List<Integer>> graph) {
        int len = graph.size();
        int[] indegree = new int[len];

        for (int i = 1; i < len; i++) {
            for (Integer next : graph.get(i)) {
                indegree[next]++;
            }
        }
        return indegree;
    }
}