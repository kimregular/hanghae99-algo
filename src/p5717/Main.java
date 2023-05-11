package p5717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean flag = true;
    static StringTokenizer st;

    static int boy;
    static int girl;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            st = new StringTokenizer(br.readLine());
            boy = Integer.parseInt(st.nextToken());
            girl = Integer.parseInt(st.nextToken());
            if (boy == 0 && girl == 0) {
                flag = false;
                break;
            }

            result = boy + girl;
            System.out.println(result);
        }



        br.close();
    }
}
