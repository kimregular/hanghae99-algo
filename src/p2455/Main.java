package p2455;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int num = 4;

    static int passenger = 0;


    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2455/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            passenger -= Integer.parseInt(st.nextToken());
            passenger += Integer.parseInt(st.nextToken());
            result = Math.max(result, passenger);
        }

        System.out.println(result);

        br.close();
    }
}
