package p5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int burgerNum = 3;
    static int drinkNum = 2;

    static int price;
    static int burger = Integer.MAX_VALUE;
    static int drink = Integer.MAX_VALUE;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < burgerNum; i++) {
            price = Integer.parseInt(br.readLine());
            burger = Math.min(burger, price);
        }
        for (int i = 0; i < drinkNum; i++) {
            price = Integer.parseInt(br.readLine());
            drink = Math.min(drink, price);
        }

        result = burger + drink - 50;
        System.out.println(result);

        br.close();
    }
}

