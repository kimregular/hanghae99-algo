package p4892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int num;
    public static int num1;
    public static int num2;
    public static int num3;
    public static int num4;
    public static int result;

    public static int guess(int num) {
        num1 = num * 3;

        if (num1 % 2 == 0) {
            num2 = num1 / 2;
        } else {
            num2 = (num1 + 1) / 2;
        }

        num3 = 3 * num2;
        num4 = num3 / 9;

        result = num4;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 1;
        String flag = "";

        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            flag = num % 2 == 0 ? "even" : "odd";

            System.out.println(i + ". "+ flag + " " + guess(num));
            i++;
        }


        br.close();
    }
}
