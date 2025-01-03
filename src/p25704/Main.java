package p25704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br), readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public int solution(int coupon, int target) {
        double totaltarget = 0;

        if (coupon < 5) {
            totaltarget = target;
        } else if (coupon >= 5 && coupon < 10) {
            totaltarget = target - 500;
        } else if (coupon >= 10 && coupon < 15) {
            totaltarget = Math.min((target * 0.9), (target - 500));
        } else if (coupon >= 15 && coupon < 20) {
            totaltarget = Math.min(((target * 0.9)), (target - 2000));
            totaltarget = Math.min(totaltarget, target - 500);
        } else if (coupon >= 20) {
            totaltarget = Math.min((target - 2000), (target * 0.75));
            totaltarget = Math.min(totaltarget, target - 500);
        }

        if (totaltarget < 0) {
            totaltarget = 0;
        }
        return (int) totaltarget;
    }
}