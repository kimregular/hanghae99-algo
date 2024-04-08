package p1337;

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
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}

class Solution {

    public int solution(int[] arr) {
        Arrays.sort(arr);

        int[] cnt = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (!contains(arr, arr[i] + j)) {
                    cnt[i]++;
                }
            }
        }
        return getMin(cnt);
    }

    private int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i : arr){
            min = Math.min(min, i);
        }
        return min;
    }

    private boolean contains(int[] arr, int num) {
        for(int i : arr){
            if(i == num) return true;
        }
        return false;
    }
}