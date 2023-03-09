package p6749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int age1;
    public static int age2;

    public static void oldAge(int age1, int age2) {
        System.out.println(age2 + (age2-age1));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        age1 = Integer.parseInt(br.readLine());
        age2 = Integer.parseInt(br.readLine());

        oldAge(age1, age2);

        br.close();
    }
}
