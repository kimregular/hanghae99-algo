package p10869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double num1;
    static double num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num1 = Double.parseDouble(st.nextToken());
        num2 = Double.parseDouble(st.nextToken());

        System.out.println((int) (num1 + num2));
        System.out.println((int) (num1 -num2));
        System.out.println((int) (num1 * num2));
        System.out.println((int) (num1 / num2));
        System.out.println((int) (num1 % num2));
        br.close();
    }
}
