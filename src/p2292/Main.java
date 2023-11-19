package p2292;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            int count = 1;
            int range = 2;

            if (target == 1) {
                System.out.println(count);
            } else {
                while (range <= target) {
                    range = range + (6 * count);
                    count++;
                }
                System.out.println(count);
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
