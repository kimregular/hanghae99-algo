package p10156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int price;
    static int num;
    static int money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());


        price = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        if (price * num - money > 0) {
            System.out.println(price * num - money);

        } else {
            System.out.println(0);
        }


        br.close();
    }
}
