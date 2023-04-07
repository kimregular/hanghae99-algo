package p21300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long result;

    static long num;
    static long tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            tmp = Long.parseLong(st.nextToken());
            num += tmp;
        }

        System.out.println(num * 5);
        br.close();
    }
}
