package p9466;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int TEST = 0; TEST < TEST_CASE; TEST++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public int solution(int[] ip) {
        Calculator c = new Calculator(ip);
        return c.getResult();
    }

    private class Calculator {

        int[] network;
        boolean[] isChecked;
        boolean[] isVisited;
        int result = 0;

        public Calculator(int[] network) {
            this.network = network;
            this.isChecked = new boolean[network.length];
            this.isVisited = new boolean[network.length];
        }

        public int getResult() {
            for (int i = 1; i < network.length; i++) {
                if(isChecked[i]) continue;
                DFS(network[i]);
            }
            return network.length - result - 1;
        }

        private void DFS(int person) {
            if(isChecked[person]) return;
            if (isVisited[person]) {
                isChecked[person] = true;
                result++;
            }

            isVisited[person] = true;
            DFS(network[person]);
            isChecked[person] = true;
            isVisited[person] = false;
        }
    }
}