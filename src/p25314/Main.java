package p25314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        for (int i = 1; i < num+1; i += 4) {
            System.out.print("long ");
        }
        System.out.print("int");
        br.close();
    }
}
