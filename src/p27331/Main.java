package p27331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result;
    static int num1;
    static int num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num1 = Integer.parseInt(br.readLine());
        num2 = Integer.parseInt(br.readLine());

        result = num1 * 10 + num2;

        System.out.println(result);

        br.close();
    }
}
