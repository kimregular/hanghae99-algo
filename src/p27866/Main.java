package p27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String[] str;
    public static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split("");
        idx = Integer.parseInt(br.readLine());

        System.out.println(str[idx-1]);

        br.close();
    }
}
