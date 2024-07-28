package p15688;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}

class Solution {

    int[] store = new int[2_000_001];
    public String solution(int[] arr) {
        for (int i : arr) {
            store[i + 1_000_000]++;
        }
        return getAnswer(arr);
    }

    private String getAnswer(int[] arr) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < store.length; i++) {
            while (store[i] > 0){
                answer.append(i - 1_000_000).append("\n");
                store[i]--;
            }

        }

        return answer.toString();
    }
}