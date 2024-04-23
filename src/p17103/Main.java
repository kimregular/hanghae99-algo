package p17103;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}

class Solution {

    Siever siever;
    StringBuilder answer;

    public Solution() {
        this.siever = new Siever();
        this.answer = new StringBuilder();
    }

    public String solution(int[] arr) {

        for (int i : arr) {
            getGoldBach(i);
        }
        return answer.toString();
    }

    private void getGoldBach(int target) {
        Set<String> goldBachs = new HashSet<>();

        for (int i : siever.getPrimeField()) {
            if(i > target) break;
            int[] goldBach = new int[2];
            goldBach[0] = i;

            if (!siever.field[target - i]) {
                goldBach[1] = target - i;
                Arrays.sort(goldBach);
                goldBachs.add(Arrays.toString(goldBach));
            }
        }
        answer.append(goldBachs.size()).append("\n");
    }
}

class Siever{

    boolean[] field = new boolean[1_000_001];
    int[] primeField;
    int numOfPrimes;

    public Siever() {
        field[0] = true;
        field[1] = true;
        setPrimeField();
    }


    public int[] getPrimeField() {
        return this.primeField;
    }

    public boolean contains(int num) {
        for(int i : primeField) if(num == i) return true;
        return false;
    }

    private void setPrimeField() {
        sieve();
        primeField = new int[numOfPrimes];
        int idx = 0;
        for (int i = 2; i < field.length; i++) {
            if(!field[i]) primeField[idx++] = i;
        }
    }

    private void sieve() {
        for (int i = 2; i < field.length; i++) {
            if(!field[i]){
                numOfPrimes++;
                for (int j = i + i; j < field.length; j += i) {
                    field[j] = true;
                }
            }
        }
    }
}