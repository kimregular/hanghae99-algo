package p2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long num1;
    static long num2;
    static long num3;

    static long mul;

    static int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num1 = Long.parseLong(br.readLine());
        num2 = Long.parseLong(br.readLine());
        num3 = Long.parseLong(br.readLine());

        mul = num1 * num2 * num3;

        while (mul > 0) {
            long tmp = mul % 10;
            arr[(int) tmp] += 1;
            mul /= 10;
        }

        for (int i : arr) {
            System.out.println(i);
        }



        br.close();
    }
}
