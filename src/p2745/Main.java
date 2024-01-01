package p2745;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String number = st.nextToken();
            int numeralSystem = Integer.parseInt(st.nextToken());

            System.out.println(Long.parseLong(number, numeralSystem));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
