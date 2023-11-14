package p1436;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET_NUM = Integer.parseInt(br.readLine());
            int cnt = 1;
            int num = 666;

            while (cnt != TARGET_NUM) {
                num++;
                if (String.valueOf(num).contains("666")) {
                    cnt++;
                }
            }

            System.out.println(num);
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
