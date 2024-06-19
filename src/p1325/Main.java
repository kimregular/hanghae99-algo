package p1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= tokens[0]; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < tokens[1]; i++) {
            int[] connected = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            network.get(connected[0]).add(connected[1]);
        }
        return network;
    }
}

class Solution {

    public String solution(List<List<Integer>> network) {
        Calculator c = new Calculator(network);
        return c.getResult();
    }

    private static class Calculator {

        List<List<Integer>> network;
        int[] mostContagiousNetwork;
        boolean[] isInfected;

        public Calculator(List<List<Integer>> network) {
            this.network = network;
            this.mostContagiousNetwork = new int[network.size()];
        }

        public String getResult() {
            explore();
            return getMostContagiousNetwork();
        }

        private void explore() {
            for (int i = 1; i < network.size(); i++) {
                isInfected = new boolean[network.size()];
                infect(i);
            }
        }

        private void infect(int start) {
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(start);
            isInfected[start] = true;

            while (!q.isEmpty()) {

                int currentComputer = q.poll();

                for (Integer nextComputer : network.get(currentComputer)) {
                    if(isInfected[nextComputer]) continue;

                    isInfected[nextComputer] = true;
                    mostContagiousNetwork[nextComputer]++;
                    q.offer(nextComputer);
                }
            }
        }

        private String getMostContagiousNetwork() {
            StringBuilder result = new StringBuilder();
            int standard = getMax(mostContagiousNetwork);
            for (int i = 1; i < mostContagiousNetwork.length; i++) {
                if (mostContagiousNetwork[i] == standard) {
                    result.append(i).append(" ");
                }
            }
            return result.toString();
        }

        private int getMax(int[] list) {
            int result = 0;
            for (Integer i : list) {
                result = Math.max(result, i);
            }
            return result;
        }

    }
}