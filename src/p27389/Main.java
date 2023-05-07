package p27389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static double num;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Double.parseDouble(br.readLine());

        result = num / 4;

        System.out.println(result);

        br.close();
    }
}
