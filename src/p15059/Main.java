package p15059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dishs;
    static int[] wants;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dishs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        wants = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < dishs.length; i++) {
            if (dishs[i] - wants[i] < 0) {

                cnt += Math.abs(dishs[i] - wants[i]);
            }
        }
        System.out.println(cnt);

        br.close();
    }
}
