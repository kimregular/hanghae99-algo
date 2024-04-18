package p1644;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }
}

class Solution{

    public int solution(int target) {
        if(target <= 1) return 0;

        Siever siever = new Siever(target);
        int[] field = siever.getPrimeNumbers();

        int answer = 0;
        int curValue = 0;

        int lp = 0;
        int rp = 0;

        while(lp <= rp && rp < field.length){
            if (curValue < target) {
                curValue += field[rp++];
            } else {
                curValue -= field[lp++];
            }
            if (curValue == target) {
                answer++;
                curValue -= field[lp++];
            }
        }

        while (lp < field.length) {
            if(curValue == target) answer++;
            curValue -= field[lp++];
        }

        return answer;
    }

    private class Siever{
        int target;
        boolean[] primeField;
        int numOfPrimeNumbers = 0;

        public Siever(int num){
            this.target = num;
            this.primeField = new boolean[num + 1];
            Arrays.fill(primeField, true);
        }

        public int[] getPrimeNumbers(){
            sieve();
            int[] primeNumbers = new int[this.numOfPrimeNumbers];
            int idx = 0;
            for (int i = 2; i < this.primeField.length; i++) {
                if (this.primeField[i]) {
                    primeNumbers[idx++] = i;
                }
            }
            return primeNumbers;
        }

        private void sieve(){
            for (int i = 2; i < this.primeField.length; i++) {
                if(this.primeField[i]){
                    this.numOfPrimeNumbers++;
                    for (int j = i + i; j < this.primeField.length; j += i) {
                        this.primeField[j] = false;
                    }
                }
            }
        }
    }
}