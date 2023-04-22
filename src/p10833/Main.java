package p10833;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static StringTokenizer st;

    static int school;

    static int apple;

    static int result;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            school = Integer.parseInt(st.nextToken());
            apple = Integer.parseInt(st.nextToken());

            result += apple % school;
        }

        System.out.println(result);

        br.close();
    }
}
