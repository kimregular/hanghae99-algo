package p24883;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        st = br.readLine();

        if ("N".equals(st) || "n".equals(st)) {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }
        br.close();
    }
}
