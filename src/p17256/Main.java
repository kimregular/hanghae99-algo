package p17256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] aCake = new long[3];
    static long[] cCake = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreElements()) {
            aCake[idx++] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        idx = 0;
        while (st.hasMoreTokens()) {
            cCake[idx++] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < aCake.length; i++) {
            if (i == 1) {
                System.out.print(cCake[i] / aCake[3 - i - 1] + " ");
            } else {
                System.out.print(cCake[i] - aCake[3 - i - 1] + " ");
            }
        }


        br.close();
    }
}
