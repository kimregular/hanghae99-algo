package p1816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            long MILLION = 1_000_000;
            long TC = Long.parseLong(br.readLine()); // TEST CASE

            for (int i = 0; i < TC; i++) {
                long num = Long.parseLong(br.readLine());

                for (long j = 2; j <= MILLION; j++) {
                    if (num % j == 0) {
                        System.out.println("NO");
                        break;
                    }

                    if (j == MILLION) {
                        System.out.println("YES");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
