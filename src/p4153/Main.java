package p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean flag = true;
    static long num1;
    static long num2;
    static long num3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            st = new StringTokenizer(br.readLine());
            num1 = Long.parseLong(st.nextToken());
            num2 = Long.parseLong(st.nextToken());
            num3 = Long.parseLong(st.nextToken());
            if(num1 == 0 && num2 == 0 && num3 == 0) break;


            if((num1 * num1 + num2 * num2) == num3 * num3) {
                sb.append("right").append('\n');
            }
            else if(num1 * num1 == (num2 * num2 + num3 * num3)) {
                sb.append("right").append('\n');
            }
            else if(num2 * num2 == (num3 * num3 + num1 * num1)) {
                sb.append("right").append('\n');
            }
            else {
                sb.append("wrong").append('\n');
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}
