package p11403;

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

    private static int[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        int[][] network = new int[len][len];

        for (int i = 0; i < network.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < network[i].length; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value != 0) network[i][j] = value;
                else network[i][j] = 1000;
            }
        }
        return network;
    }
}

class Solution {

    public String solution(int[][] network) {
        return getAnswer(FW(network));
    }

    private String getAnswer(int[][] network) {
        StringBuilder answer = new StringBuilder();

        for (int[] ints : network) {
            for (int i : ints) {
                if(i == 1000) answer.append("0");
                else answer.append("1");
                answer.append(" ");
            }
            answer.append("\n");
        }

        return answer.toString();
    }

    private int[][] FW(int[][] network) {
        for (int k = 0; k < network.length; k++) {
            for (int i = 0; i < network.length; i++) {
                for (int j = 0; j < network.length; j++) {
                    network[i][j] = Math.min(network[i][j], network[i][k] + network[k][j]);
                }
            }
        }
        return network;
    }
}