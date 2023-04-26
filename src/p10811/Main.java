package p10811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int numOfBuckets;

    static int[] buckets;

    static int numOfChange;

    static int left;

    static int right;

    static void reverseBuckets(int left, int right, int[] buckets) {
        int[] tmp = new int[right - left + 1];
        int idx = 0;
        for (int i = right-1; i >= left-1; i--) {
            tmp[idx++] = buckets[i];
        }
        idx = 0;
        for (int i = left - 1; i < right; i++) {
            buckets[i] = tmp[idx++];
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        numOfBuckets = Integer.parseInt(st.nextToken());
        buckets = new int[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = i + 1;
        }

        numOfChange = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numOfChange; i++) {
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            reverseBuckets(left, right, buckets);
        }

        for (int i = 0; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }

        br.close();
    }
}
