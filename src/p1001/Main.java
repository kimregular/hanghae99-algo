package p1001;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int num1;
    static int num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        System.out.println(num1 - num2);

        br.close();
    }
}
