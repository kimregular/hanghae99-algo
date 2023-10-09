package p27590;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer sunInfo = new StringTokenizer(br.readLine(), " ");
            StringTokenizer moonInfo = new StringTokenizer(br.readLine(), " ");

            int dayOfSun = Integer.parseInt(sunInfo.nextToken());
            int yearOfSun = Integer.parseInt(sunInfo.nextToken());
            int dayOfMoon = Integer.parseInt(moonInfo.nextToken());
            int yearOfMoon = Integer.parseInt(moonInfo.nextToken());

            int sunYear = yearOfSun - dayOfSun;
            int moonYear = yearOfMoon - dayOfMoon;

            while(sunYear != moonYear){
                if (sunYear < moonYear) {
                    sunYear += yearOfSun;
                } else {
                    moonYear += yearOfMoon;
                }
            }

            System.out.println(sunYear);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
