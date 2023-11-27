package p18110;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfDigits = Integer.parseInt(br.readLine());
            int[] arr = new int[numOfDigits];

            for (int i = 0; i < numOfDigits; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            SolvedAc sa = new SolvedAc(arr);
            System.out.println(sa.getResult());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class SolvedAc {

    int[] arr;

    public SolvedAc(int[] arr) {
        Arrays.sort(arr);
        this.arr = arr;
    }

    public int getResult() {
        double threshold = Math.round(this.arr.length * 0.15);
        int total = 0;
        int numOfTarget = 0;
        for (int i = (int) threshold; i < arr.length - threshold; i++) {
            total += arr[i];
            numOfTarget++;
        }
        return (int) myRound((double) total /numOfTarget);
    }

    private double myRound(double num) {
        double check = num % 1 * 10;
        if(check < 5) return Math.floor(num);
        return Math.ceil(num);
    }
}