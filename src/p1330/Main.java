package p1330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num1;
    static int num2;

    static String whichBig(int num1, int num2) {
        if (num1 == num2) {
            return "==";
        } else if (num1 > num2) {
            return ">";
        }
        return "<";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());

        System.out.println(whichBig(num1, num2));

        br.close();
    }
}
