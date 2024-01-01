package p11719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();

                if (input == null) {
                    break;
                } else {
                    System.out.println(input);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
