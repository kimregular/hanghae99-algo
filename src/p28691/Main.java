package p28691;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            switch (br.readLine()) {
                case "M":
                    System.out.println("MatKor");
                    break;
                case "W":
                    System.out.println("WiCys");
                    break;
                case "C":
                    System.out.println("CyKor");
                    break;
                case "A":
                    System.out.println("AlKor");
                    break;
                case "$":
                    System.out.println("$clear");
                    break;
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}