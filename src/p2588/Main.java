package p2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num1;
    static String[] num2;

    static void calc(int num1, String[] num2) {
        for (int i = 2; i >= 0 ; i--) {
            System.out.println(Integer.parseInt(num2[i]) * num1);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num1 = Integer.parseInt(br.readLine());
        num2 = br.readLine().split("");

        calc(num1, num2);

        System.out.println(Integer.parseInt(String.join("", num2)) * num1);

        br.close();
    }
}
