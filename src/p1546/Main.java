package p1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int len;

    static double[] arr;

    static int max = Integer.MIN_VALUE;

    static double total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());
        arr = new double[len];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            arr[idx++] = tmp;
        }

        for (int i = 0; i < arr.length; i++) {
            total += (arr[i] / max) * 100;
        }

        System.out.println(total / len);



        br.close();
    }
}
