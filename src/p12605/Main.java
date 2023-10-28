package p12605;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                String[] str = br.readLine().split(" ");
                System.out.print("Case #" + (i + 1) + ": ");
                for (int j = 0; j < str.length; j++) {
                    System.out.print(str[str.length - 1 - j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
