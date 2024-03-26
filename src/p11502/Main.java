package p11502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String solution(int[] arr) {
        return getAnswer(arr);
    }

    private String getAnswer(int[] arr) {
        StringBuilder answer = new StringBuilder();
        for (int i : arr) {
            Sieve sieve = new Sieve(i);
            ThreePrimeProblemSolver tpps = new ThreePrimeProblemSolver(i, sieve.getPrimeNums());
            int[] result = tpps.solveThreePrimeProblem();
            if (isSolved(result)) {
                for (int primeNum : result) {
                    answer.append(primeNum).append(" ");
                }
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    private boolean isSolved(int[] result) {
        int sum = 0;
        for (int i : result) {
            sum += i;
        }

        return sum != 0;
    }
}

class ThreePrimeProblemSolver {

    int target;
    List<Integer> sievedNums;

    public ThreePrimeProblemSolver(int target, List<Integer> sievedNums) {
        this.target = target;
        this.sievedNums = sievedNums;
    }

    public int[] solveThreePrimeProblem() {
        for (Integer sievedNum1 : this.sievedNums) {
            for (Integer sievedNum2 : this.sievedNums) {
                for (Integer sievedNum3 : this.sievedNums) {
                    if(sievedNum1 + sievedNum2 + sievedNum3 == this.target)
                        return new int[]{sievedNum1, sievedNum2, sievedNum3};
                }
            }
        }
        return new int[]{0, 0, 0};
    }
}

class Sieve {

    boolean[] sieve;

    List<Integer> primeNums;

    public Sieve(int limit) {
        this.sieve = new boolean[limit + 1];
        Arrays.fill(this.sieve, true);
        this.primeNums = getSievedNums();
    }

    private List<Integer> getSievedNums() {
        List<Integer> sievedNums = new ArrayList<>();

        for (int i = 2; i < this.sieve.length; i++) {
            if (this.sieve[i]) {
                sievedNums.add(i);
                sieveNums(i);
            }
        }
        return sievedNums;
    }

    private void sieveNums(int num) {
        for (int i = num * 2; i < this.sieve.length; i += num) {
            this.sieve[i] = false;
        }
    }

    public List<Integer> getPrimeNums() {
        return this.primeNums;
    }
}