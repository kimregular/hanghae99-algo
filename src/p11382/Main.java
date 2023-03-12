package p11382;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p11382/text.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 3; i++) {
            result += Long.parseLong(st.nextToken());
        }

        System.out.println(result);

        br.close();
    }
}
