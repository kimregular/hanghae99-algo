package p11815;

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

    private static long[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        long[] result = new long[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public String solution(long[] targets) {
        StringBuilder answer = new StringBuilder();
        for (long target : targets) {
            answer.append(isSquareNumber(target)).append(" ");
        }

        return answer.toString();
    }

    private int isSquareNumber(long target) {
        long root = (long) Math.sqrt(target);

        if(root * root == target) return 1;
        return 0;
    }
}