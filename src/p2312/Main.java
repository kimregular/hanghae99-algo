package p2312;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] targetList = new int[len];
        for (int i = 0; i < targetList.length; i++) {
            targetList[i] = Integer.parseInt(br.readLine());
        }
        return targetList;
    }
}

class Solution {

    Siever siever;
    StringBuilder answer;

    public Solution() {
        this.siever = new Siever();
        this.answer = new StringBuilder();
    }

    public String solution(int[] targetList){
        for (int target : targetList) {
            calc(target);
        }
        return answer.toString();
    }

    private void calc(int target) {
        int[] divisorList = new int[target + 1];
        while (target > 1) {
            for (int i : siever.primeField) {
                if(target == 1) break;
                if (target % i == 0) {
                    while (target % i == 0) {
                        target /= i;
                        divisorList[i]++;
                    }
                }
            }
        }

        for (int i = 2; i < divisorList.length; i++) {
            if(divisorList[i] == 0) continue;
            answer.append(i).append(" ").append(divisorList[i]).append("\n");
        }
    }
}

class Siever{

    boolean[] field = new boolean[100_001];

    int numOfPrime = 0;
    int[] primeField = getPrimeField();


    public int[] getPrimeField() {
        sieveNumbers();

        int[] primeField = new int[this.numOfPrime];

        int idx = 0;

        for (int i = 2; i < this.field.length; i++) {
            if (!this.field[i]) {
                primeField[idx++] = i;
            }
        }

        return primeField;
    }
    private void sieveNumbers() {
        for (int i = 2; i < this.field.length; i++) {
            if (!this.field[i]) {
                this.numOfPrime++;
                for (int j = i + i; j < this.field.length; j += i) {
                    this.field[j] = true;
                }
            }
        }
    }
}