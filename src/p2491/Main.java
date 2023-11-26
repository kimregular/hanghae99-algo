package p2491;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfDigits = Integer.parseInt(br.readLine());
            int[] arr = new int[numOfDigits];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < numOfDigits; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution(arr);
            System.out.println(s.solution());
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] arr;

    public Solution(int[] arr) {
        this.arr = arr;
    }

    public int solution() {
        return Math.max(ascending(), descending());
    }

    private int ascending() {
        int ascending = 1;
        int ascendingTmp = 1;
        for (int i = 0; i < this.arr.length - 1; i++) {
            if (this.arr[i] <= this.arr[i + 1]) {
                ascendingTmp++;
            } else {
                if(ascending < ascendingTmp) ascending = ascendingTmp;
                ascendingTmp = 1;
            }
        }
        if(ascending < ascendingTmp) ascending = ascendingTmp;
        return ascending;
    }

    private int descending() {
        int descending = 1;
        int descendingTmp = 1;

        for (int i = this.arr.length - 1; i > 0; i--) {
            if (this.arr[i] <= this.arr[i - 1]) {
                descendingTmp++;
            } else {
                if(descending < descendingTmp) descending = descendingTmp;
                descendingTmp = 1;
            }
        }
        if(descending < descendingTmp) descending = descendingTmp;
        return descending;
    }
}