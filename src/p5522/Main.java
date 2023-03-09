package p5522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        for (int i = 0; i < 5; i++) {
            result +=Integer.parseInt(br.readLine());
        }

        System.out.println(result);
        br.close();
    }
}
