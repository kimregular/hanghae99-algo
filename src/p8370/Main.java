package p8370;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] lines = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p8370/text.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i = 0;
        while (st.hasMoreTokens()) {
            lines[i++] = Integer.parseInt(st.nextToken());
        }

        System.out.println(lines[0] * lines[1] + lines[2] * lines[3]);

        br.close();
    }
}
