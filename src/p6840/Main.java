package p6840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] bowls = new int[3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            bowls[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bowls);
        System.out.println(bowls[1]);

        br.close();
    }
}
