package p27959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    static int coin;

    static int price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        coin = Integer.parseInt(st.nextToken());
        price = Integer.parseInt(st.nextToken());


        if (coin * 100 >= price) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


        br.close();
    }
}

