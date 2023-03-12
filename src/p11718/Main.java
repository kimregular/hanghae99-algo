package p11718;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p11718/text.txt"));

        while ((str = br.readLine()) != null) {

            System.out.println(str);
        }

        br.close();
    }
}
