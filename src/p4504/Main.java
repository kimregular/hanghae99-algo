package p4504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET = Integer.parseInt(br.readLine());

            while (true) {
                int tmp = Integer.parseInt(br.readLine());
                if (tmp == 0) {
                    break;
                }

                if (tmp % TARGET == 0) {
                    System.out.println(tmp + " is a multiple of " + TARGET + ".");
                } else {
                    System.out.println(tmp + " is NOT a multiple of " + TARGET+ ".");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
