package p15688;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        System.out.println(s.solution(getInput(br)));
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

    public String solution(int[] arr) {
        Arrays.sort(arr);
        return getAnswer(arr);
    }

    private String getAnswer(int[] arr) {
        StringBuilder answer = new StringBuilder();
        for(int i : arr) answer.append(i).append("\n");
        return answer.toString();
    }
}