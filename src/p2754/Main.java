package p2754;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String[] score;
    public static double result;

    public static double myScore(String[] score) {
        switch (score[0]) {
            case "A":
                result = 4;
                break;
            case "B":
                result = 3;
                break;
            case "C":
                result = 2;
                break;
            case "D":
                result = 1;
                break;
            default:
                result = 0;
                break;
        }
        if (score[0].equals("F")) {
            return result;
        }
        if (score[1].equals("+")) {
            result += 0.3;
        } else if (score[1].equals("-")) {
            result -= 0.3;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        score = br.readLine().split("");
        System.out.println(myScore(score));
        br.close();
    }
}
