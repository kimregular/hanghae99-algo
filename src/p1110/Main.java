package p1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PlusCycleFinder pcf = new PlusCycleFinder();
        System.out.println(pcf.findPlusCycle(n));

        br.close();
    }
}

class PlusCycleFinder {

    public int findPlusCycle(int n) {
        int cnt = 0;
        boolean flag = true;

        int target = n;
        int right = 0, left = 0;
        while (flag) {

//            if (target < 10) {
//                target = target * 10 + target;
//            }
//            System.out.println(target);

            right = target % 10;
            left = target / 10 + right;

            target = right * 10 + left % 10;
            cnt++;

//            System.out.println(cnt + " : " + target + " = " + right + " + " + left);

            if (n == target) {
                flag = false;
            }
        }

        return cnt;
    }
}
