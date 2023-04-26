package p2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int a;
    static int b;
    static int c;

    static int getAward(int a, int b, int c) {
        int award = 0;

        if (a == b && b == c) {
            award = 10000 + a * 1000;
            return award;
        } else if (a != c && a == b) {
            award = 1000 + a * 100;
            return award;
        } else if (b != c && a == c) {
            award = 1000 + a * 100;
            return award;
        } else if (a != b && b == c) {
            award = 1000 + b * 100;
            return award;
        } else {
            int tmp = Math.max(a, b);
            tmp = Math.max(tmp, c);
            award = tmp * 100;
            return award;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(getAward(a, b, c));

        br.close();
    }
}
