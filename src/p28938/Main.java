package p28938;

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

    public static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public String solution(int[] ip) {
        int start = 0;
        for(int i : ip) start += i;

        if(start == 0) return "Stay";
        if(start > 0) return "Right";
        return "Left";
    }
}