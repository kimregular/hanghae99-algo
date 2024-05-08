package p18301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = br.readLine().split(" ");
            int num1 = Integer.parseInt(tokens[0]);
            int num2 = Integer.parseInt(tokens[1]);
            int num3 = Integer.parseInt(tokens[2]);


            System.out.println((num1 + 1) * (num2+1) / (num3+1) - 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
