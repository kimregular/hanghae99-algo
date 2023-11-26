package p2775;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                int k = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(br.readLine());
                System.out.println(s.solution(k, n));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[][] arr = new int[15][15];

    public Solution() {
        for (int i = 0; i < arr.length; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            int numOfPeople = arr[i-1][0];
            for (int j = 0; j < arr[i-1].length; j++) {
                numOfPeople += arr[i-1][j];
                arr[i][j] = numOfPeople;
            }
        }
    }

    public int solution(int k, int n) {
        return arr[k][n];
    }
}