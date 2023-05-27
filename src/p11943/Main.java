package p11943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static long[] arr1 = new long[2];
    static long[] arr2 = new long[2];

    static long getNum(long[] arr1, long[] arr2) {
        return Math.min(arr1[0] + arr2[1], arr1[1] + arr2[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 2; i++) {
            arr1[idx++] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        idx = 0;
        for (int i = 0; i < 2; i++) {
            arr2[idx++] = Long.parseLong(st.nextToken());
        }

        System.out.println(getNum(arr1, arr2));


        br.close();
    }
}
