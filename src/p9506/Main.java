package p9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int num = Integer.parseInt(br.readLine());
                if(num == -1) break;

                System.out.println(isPerfectNum(num));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String isPerfectNum(int num) {
        int sumOfFactor = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sumOfFactor += i;
                arr.add(String.valueOf(i));
            }
        }
        if (sumOfFactor == num) {
            String factors = String.join(" + ", arr);
            return num + " = " + factors;
        }
        return num + " is NOT perfect.";
    }
}
