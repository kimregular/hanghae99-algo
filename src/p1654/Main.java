package p1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            Solution s = new Solution(arr, target);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] arr;
    int target;

    public Solution(int[] arr, int target) {
        this.arr = arr;
        this.target = target;
    }

    public long solution() {
        long lp = 1;
        long rp = arr[arr.length - 1];

        while (lp <= rp) {

            long cnt = 0;

            long mid = (lp + rp) / 2;

            for (int i : arr) {
                cnt += i / mid;
            }

            if (cnt < target) {
                rp = mid - 1;
            } else {
                lp = mid + 1;
            }
        }

        return rp;
    }
}