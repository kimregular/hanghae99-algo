package p25238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double num;
    static double num2;

    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Double.parseDouble(st.nextToken());
        num2 = Double.parseDouble(st.nextToken());

        result = num - (num * (num2 / 100));

        if (result >= 100) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        br.close();
    }
}
