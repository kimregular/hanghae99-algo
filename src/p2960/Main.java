package p2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Solution s = new Solution(n, k);
            System.out.println(s.solution());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] arr;
    int k;

    public Solution(int n, int k) {
        this.arr = new int[n + 1];
        this.k = k;
    }

    public int solution() {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 2; i < this.arr.length; i++) {
            if (this.arr[i] == 0) {
                for (int j = i; j < this.arr.length; j += i) {
                    if (this.arr[j] != 1) {
                        this.arr[j] = 1;
                        results.add(j);
                    }
                }
            }
        }
        return results.get(this.k-1);
    }
}