package p15873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String[] num;
    static int num1;
    static int num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = br.readLine().split("");
        if (num.length == 4) {
            num1 = 10;
            num2 = 10;
        } else if (num.length == 3) {
            int idx = Arrays.asList(num).indexOf("0");
            if (idx % 2 == 0) {
                num2 = Integer.parseInt(num[1]) * 10;
                num1 = Integer.parseInt(num[0]);
            } else {
                num1 = Integer.parseInt(num[0]) * 10;
                num2 = Integer.parseInt(num[2]);
            }
        } else {
            num1 = Integer.parseInt(num[0]);
            num2 = Integer.parseInt(num[1]);
        }

        System.out.println(num1 + num2);
        br.close();
    }
}
