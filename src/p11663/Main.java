package p11663;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tokens = br.readLine().split(" ");
            Solution s = new Solution();
            System.out.println(s.solution(getDots(br), getLines(br, Integer.parseInt(tokens[1]))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getDots(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    }

    private static int[][] getLines(BufferedReader br, int len) throws IOException {
        int[][] lines = new int[len][2];
        for (int i = 0; i < lines.length; i++) {
            String[] tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            lines[i] = new int[]{start, end};
        }
        return lines;
    }
}

class Solution {

    public String solution(int[] dots, int[][] lines) {
        Calculator c = new Calculator(dots, lines);
        return c.getResult();
    }
}

class Calculator {

    int[] dots;
    int[][] lines;
    int[] numOfDots;
    StringBuilder result = new StringBuilder();

    public Calculator(int[] dots, int[][] lines) {
        this.dots = dots;
        this.lines = lines;
        this.numOfDots = new int[lines.length];
    }

    public String getResult() {
        for (int i = 0; i < lines.length; i++) {
            numOfDots[i] = search(lines[i][0], lines[i][1]);
        }
        for (int num : numOfDots) {
            result.append(num).append("\n");
        }
        return result.toString();
    }

    private int search(int start, int end) {
        return getUpperBound(end) - getLowerBound(start);
    }

    private int getUpperBound(int num) {
        int lp = 0;
        int rp = dots.length;

        while (lp < rp) {
            int mid = (lp + rp) / 2;

            if (dots[mid] <= num) {
                lp = mid + 1;
            } else {
                rp = mid;
            }
        }
        return rp;
    }

    private int getLowerBound(int num) {
        int lp = 0;
        int rp = dots.length;

        while (lp < rp) {
            int mid = (lp + rp) / 2;

            if (dots[mid] < num) {
                lp = mid + 1;
            } else {
                rp = mid;
            }
        }
        return rp;
    }
}