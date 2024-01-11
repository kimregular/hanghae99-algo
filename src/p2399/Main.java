package p2399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            long[] arr = new long[len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            Solution s = new Solution(arr);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Solution {

    long[] arr;

    public Solution(long[] arr) {
        Arrays.sort(arr);
        this.arr = arr;
    }

    public long solution() {
        long result = 0;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length; j++) {
                result += Math.abs(this.arr[i] - this.arr[j]);
            }
        }
        return result;
    }
}