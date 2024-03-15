package p13909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println((int) Math.sqrt(Integer.parseInt(br.readLine())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
