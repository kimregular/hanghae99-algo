package p10813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int numOfBuckets;

    static int numOfChange;

    static int[] buckets;

    static int left;

    static int right;

    static void changeBall(int left, int right, int[] buckets) {
        int tmp = buckets[left- 1];
        buckets[left - 1] = buckets[right - 1];
        buckets[right - 1] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        numOfBuckets = Integer.parseInt(st.nextToken());
        buckets = new int[numOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = i + 1;
        }

        numOfChange = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numOfChange; i++) {
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            changeBall(left, right, buckets);
        }

        for (int i = 0; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }


        br.close();
    }
}
