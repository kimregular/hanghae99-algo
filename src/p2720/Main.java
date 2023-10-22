package p2720;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                int income = Integer.parseInt(br.readLine());

                ChangeCalc cc = new ChangeCalc(income);
                for (int x : cc.calcChange()) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ChangeCalc {

    int income;
    int[] coins = {25, 10, 5, 1};
    int[] change = new int[4];

    public ChangeCalc(int income) {
        this.income = income;
    }

    public int[] calcChange() {

        int idx = 0;
        for (double coin : coins) {
            change[idx++] = (int) (income / coin);
            income %= coin;
        }

        return this.change;
    }
}