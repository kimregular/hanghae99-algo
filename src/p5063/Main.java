package p5063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int num;

    static int noAds;
    static int withAds;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            noAds = Integer.parseInt(st.nextToken());
            withAds = Integer.parseInt(st.nextToken());
            withAds -= Integer.parseInt(st.nextToken());

            if (noAds - withAds < 0) {
                System.out.println("advertise");
            } else if (noAds - withAds > 0) {
                System.out.println("do not advertise");
            } else {
                System.out.println("does not matter");
            }

        }

        br.close();
    }
}
