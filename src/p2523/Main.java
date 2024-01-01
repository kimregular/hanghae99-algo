package p2523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String star = "*";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= num; i++) {
                System.out.println(star.repeat(i));
            }
            for (int i = num - 1; i >= 1; i--) {
                System.out.println(star.repeat(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
