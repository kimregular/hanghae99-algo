package p6118;

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
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numOfBarns = tokens[0];
        int numOfNodes = tokens[1];

        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= numOfBarns; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfNodes; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = temp[0];
            int to = temp[1];

            network.get(from).add(to);
            network.get(to).add(from);
        }

        return network;
    }
}

class Solution {

    public String solution(List<List<Integer>> network) {
        Calculator c = new Calculator(network);
        return c.getResult();
    }

    private static class Calculator{

        List<List<Integer>> network;
        int[] distance;
        boolean[] isVisited;
        StringBuilder result = new StringBuilder();




        public Calculator(List<List<Integer>> network) {
            this.network = network;
            this.distance = new int[network.size()];
            Arrays.fill(distance, 50_001);
            this.isVisited = new boolean[network.size()];
        }

        public String getResult() {
            calculate();
            return postProcess();
        }

        private String postProcess() {
            int curDistance = 0;
            int targetBarn = 0;
            int numOfTargetBarns = 0;

            for (int i = 1; i < distance.length; i++) {
                if (distance[i] > curDistance) {
                    curDistance = distance[i];
                    targetBarn = i;
                    numOfTargetBarns = 1;
                } else if (distance[i] == curDistance) {
                    numOfTargetBarns++;
                }
            }

            return result.append(targetBarn).append(" ").append(distance[targetBarn]).append(" ").append(numOfTargetBarns).toString();
        }


        private void calculate() {
            Queue<Barn> q = new ArrayDeque<>();
            q.offer(new Barn(1, 0));
            isVisited[1] = true;

            while (!q.isEmpty()) {

                Barn currentBarn = q.poll();
                int currentLocation = currentBarn.location;
                int currentDistance = currentBarn.distance;
                distance[currentLocation] = Math.min(distance[currentLocation], currentDistance);

                for (int nextBarn : network.get(currentLocation)) {
                    if(isVisited[nextBarn]) continue;

                    isVisited[nextBarn] = true;
                    q.offer(new Barn(nextBarn, currentDistance + 1));
                }
            }
        }

        private class Barn{

            int location;
            int distance;

            public Barn(int location, int distance) {
                this.location = location;
                this.distance = distance;
            }
        }
    }
}