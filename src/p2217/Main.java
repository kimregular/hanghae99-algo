package p2217;

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
        int len = Integer.parseInt(br.readLine());
        int[] ropes = new int[len];
        for (int i = 0; i < ropes.length; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        return ropes;
    }
}

class Solution {

    public int solution(int[] ropes) {
        Arrays.sort(ropes);

        int maxWeight = 0;

        for (int i = 0; i < ropes.length; i++) {
            int available = ropes[i];

            maxWeight = Math.max(maxWeight, available * (ropes.length - i));
        }

        return maxWeight;
    }
}