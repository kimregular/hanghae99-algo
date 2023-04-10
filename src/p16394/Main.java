package p16394;

import java.util.Scanner;

public class Main {

    static int foundation = 1946;

    static int year;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        year = sc.nextInt();

        System.out.println(year - foundation);

        sc.close();
    }
}
