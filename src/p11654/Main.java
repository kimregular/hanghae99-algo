package p11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char letter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        letter = (char) br.read();

        System.out.println((int) letter);


        br.close();
    }
}
