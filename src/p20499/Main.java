package p20499;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        return new int[]{k, d, a};
    }
}

class Solution {

    public String solution(int[] input) {
        int k = input[0];
        int d = input[1];
        int a = input[2];
        if (isTrue(k, d, a)) return "gosu";
        return "hasu";
    }

    private boolean isTrue(int k, int d, int a) {
        return d != 0 && k + a >= d;
    }
}
