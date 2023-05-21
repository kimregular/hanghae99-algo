package p4458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            sb = new StringBuilder(br.readLine());
            String newSt = String.valueOf(sb.charAt(0)).toUpperCase();
            sb.replace(0, 1, newSt);
            System.out.println(sb);
        }


        br.close();
    }
}
