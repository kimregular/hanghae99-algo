package p15552;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int num1;
    static int num2;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            sum = num1 + num2;
            bw.write(sum + "\n");
        }

        bw.flush();
        br.close();
    }
}
