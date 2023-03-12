package p27323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num1;
    static int num2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num1 = Integer.parseInt(br.readLine());
        num2 = Integer.parseInt(br.readLine());

        System.out.println(num1 * num2);

        br.close();
    }
}
