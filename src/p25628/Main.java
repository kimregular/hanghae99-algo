package p25628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int bread;
    static int meat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        bread = Integer.parseInt(st.nextToken());
        meat = Integer.parseInt(st.nextToken());

        bread /= 2;

        if (bread == 0) {
            System.out.println(0);
        } else System.out.println(Math.min(bread, meat));


        br.close();
    }
}
