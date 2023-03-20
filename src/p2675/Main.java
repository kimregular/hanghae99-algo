package p2675;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int loop;

    static char[] sts;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2675/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            loop = Integer.parseInt(st.nextToken());
            sts = st.nextToken().toCharArray();
            for (char c : sts) {
                for (int j = 0; j < loop; j++) {
                    System.out.print(c);
                }
            }
                System.out.println();
        }

        br.close();
    }
}
