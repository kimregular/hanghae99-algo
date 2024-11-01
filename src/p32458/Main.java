package p32458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String target = br.readLine();
            double dNum = Double.parseDouble(target);
            System.out.println((int) dNum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
