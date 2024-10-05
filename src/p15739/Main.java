package p15739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][len];
        for (int i = 0; i < result.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] magicSquare) {
        if(hasDuplicateNum(magicSquare)) return "FALSE";
        if(hasNoEvenSum(magicSquare)) return "FALSE";
        return "TRUE";
    }

    private boolean hasDuplicateNum(int[][] magicSquare) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                if(set.contains(magicSquare[i][j])) return true;
                else set.add(magicSquare[i][j]);
            }
        }
        return false;
    }

    private boolean hasNoEvenSum(int[][] magicSquare) {
        int n = magicSquare.length;
        int magicNumber = n * (n * n + 1) / 2;

        for (int i = 0; i < n; i++) {
            int numberCheck1 = 0;
            int numberCheck2 = 0;
            for (int j = 0; j < n; j++) {
                numberCheck1 += magicSquare[i][j];
                numberCheck2 += magicSquare[j][i];
            }
            if(numberCheck1 != magicNumber) return true;
            if(numberCheck2 != magicNumber) return true;
        }

        int numberCheck1 = 0;
        int numberCheck2 = 0;
        for (int i = 0; i < n; i++) {
            numberCheck1 += magicSquare[i][i];
            numberCheck2 += magicSquare[i][n - i - 1];
        }

        if(numberCheck1 != magicNumber) return true;
        if(numberCheck2 != magicNumber) return true;

        return false;
    }
}