package p6778;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int antennas;
    public static int eyes;

    public static void whichAlien(int antennas, int eyes) {

        if (antennas >= 3 && eyes <= 4) {
            System.out.println("TroyMartian");
        }
        if (antennas <= 6 && eyes >= 2) {
            System.out.println("VladSaturnian");
        }
        if (antennas <= 2 && eyes <= 3) {
            System.out.println("GraemeMercurian");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        antennas = Integer.parseInt(br.readLine());
        eyes = Integer.parseInt(br.readLine());

        whichAlien(antennas, eyes);

        br.close();
    }
}
