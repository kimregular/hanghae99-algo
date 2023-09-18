package p1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int LEN = Integer.parseInt(br.readLine());

            int[] a = new int[LEN];
            int[] b = new int[LEN];

            StringTokenizer aST = new StringTokenizer(br.readLine(), " ");
            StringTokenizer bST = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < LEN; i++) {
                a[i] = Integer.parseInt(aST.nextToken());
                b[i] = Integer.parseInt(bST.nextToken());
            }

            Solution s = new Solution(a, b);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] arr;
    int[] brr;

    public Solution(int[] arr, int[] brr) {
        this.arr = arr;
        this.brr = brr;
    }

    public int solution() {
        int smallSum = 0;

        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i = 0; i < arr.length; i++) {
            smallSum += arr[i] * brr[brr.length - i - 1];
        }

        return smallSum;
    }

}
