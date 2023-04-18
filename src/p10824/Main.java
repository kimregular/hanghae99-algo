package p10824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static String s1;
    static String s2;

    static long num1;
    static long num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        s1 = st.nextToken();
        s1 += st.nextToken();
        s2 = st.nextToken();
        s2 += st.nextToken();

        num1 = Long.parseLong(s1);
        num2 = Long.parseLong(s2);

        System.out.println(num1 + num2);



        br.close();
    }
}
