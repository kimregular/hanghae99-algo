package p2609;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int num1;
    public static int num2;

    public static int gcd;
    public static int lcm;

    public static int GCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return GCD(num2, num1 % num2);
        }
    }

    public static int LCM(int num1, int num2, int gcd) {
        return gcd * (num1 / gcd) * (num2 / gcd);
    }




    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p2609/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        num1 = Integer.parseInt(nums[0]);
        num2 = Integer.parseInt(nums[1]);

        gcd = GCD(num1, num2);
        lcm = LCM(num1, num2, gcd);
        System.out.println(gcd);
        System.out.println(lcm);


        br.close();
    }
}
