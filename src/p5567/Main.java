package p5567;

import java.io.*;
import java.util.*;

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
        int numOfPeople = Integer.parseInt(br.readLine());
        int numOfRelation = Integer.parseInt(br.readLine());
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i <= numOfPeople; i++) {
            relation.add(new ArrayList<>());
        }
        for (int i = 0; i < numOfRelation; i++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            relation.get(from).add(to);
            relation.get(to).add(from);
        }
        return relation;
    }
}

class Solution {

    public int solution(List<List<Integer>> relation) {
        Calculator c = new Calculator(relation);
        return c.getResult();
    }
}

class Calculator {

    List<List<Integer>> relation;
    boolean[] isVisited;

    public Calculator(List<List<Integer>> relation) {
        this.relation = relation;
        this.isVisited = new boolean[relation.size()];
        isVisited[1] = true;
    }

    public int getResult() {
        DFS(1, 0);
        int result = 0;
        for (int i = 2; i < isVisited.length; i++) {
            if(isVisited[i]) result++;
        }
        return result;
    }

    private void DFS(int friend, int depth) {
        if(depth == 2) return;

        for (int nextFriend : relation.get(friend)) {
            isVisited[nextFriend] = true;
            DFS(nextFriend, depth + 1);
        }
    }
}