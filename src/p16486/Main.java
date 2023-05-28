package p16486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static double d1;
    static double d2;
    static double getPerimeter(double d1, double d2) {
        double cirPer = 2 * d2 * Math.PI;
        return cirPer + (d1 * 2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        d1 = Double.parseDouble(br.readLine());
        d2 = Double.parseDouble(br.readLine());

        System.out.println(getPerimeter(d1, d2));


        br.close();
    }
}
