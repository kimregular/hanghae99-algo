package p5596;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int num1;
    static int num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            num1 += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            num2 += Integer.parseInt(st.nextToken());
        }

        if (num1 >= num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
        br.close();
    }
}
