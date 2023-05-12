package p10039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 5; i++) {
            num = Integer.parseInt(br.readLine());
            if (num < 40) {
                result += 40;
            } else {
                result += num;
            }
        }

        System.out.println(result/5);


        br.close();
    }
}
