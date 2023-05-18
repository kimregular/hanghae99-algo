package p14470;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int a;
    static int b;
    static int c;
    static int d;
    static int e;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p14470/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        if (a < 0) {
            System.out.println(Math.abs(a * c) + d + (b * e));
        } else {
            System.out.println((b - a) * e );
        }

        br.close();
    }
}
