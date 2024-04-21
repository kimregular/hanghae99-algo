package p9020;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        return nums;
    }
}

class Solution {

    Siever siever;
    StringBuilder answer;

    public Solution() {
        this.siever = new Siever();
        this.answer = new StringBuilder();
    }

    public String solution(int[] targets) {

        for (int target : targets) {
            List<int[]> goldBachs = new ArrayList<>();

            for (int prime : siever.primeField) {
                if(prime > target) break;
                if (siever.contains(target - prime)) {
                    goldBachs.add(new int[]{prime, target - prime});
                }
            }

            saveGoldBach(goldBachs);
        }
        return answer.toString();
    }

    private void saveGoldBach(List<int[]> goldBachs) {
        int[] saveTarget = goldBachs.get(0);

        for (int[] saveCandidate : goldBachs) {
            if (Math.abs(saveTarget[0] - saveTarget[1]) > Math.abs(saveCandidate[0] - saveCandidate[1])) {
                saveTarget = saveCandidate;
            }
        }
        Arrays.sort(saveTarget);

        this.answer.append(saveTarget[0]).append(" ").append(saveTarget[1]).append("\n");
    }
}

class Siever{

    boolean[] field = new boolean[10_001];

    int[] primeField;
    int numOfPrimes = 0;

    public Siever() {
        primeField = createPrimeField();
    }

    public boolean contains(int target) {
        for (int i : primeField) {
            if(target == i) return true;
        }
        return false;
    }

    private int[] createPrimeField() {
        sieve();
        int[] primeField = new int[numOfPrimes];
        int idx = 0;
        for (int i = 2; i < field.length; i++) {
            if(field[i]) continue;
            primeField[idx++] = i;
        }
        return primeField;
    }

    private void sieve() {
        for (int i = 2; i < this.field.length; i++) {
            if (!field[i]) {
                numOfPrimes++;
                for (int j = i + i; j < this.field.length; j += i) {
                    field[j] = true;
                }
            }
        }
    }
}