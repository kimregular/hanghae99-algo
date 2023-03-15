package p10810;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;

    static int idx1;
    static int idx2;
    static int ballNum;

    static int[] buckets;

    static void fillBalls(int[] buckets, int idx1, int idx2, int ballNum) {
        for (int i = idx1-1; i < idx2; i++) {
            buckets[i] = ballNum;
        }
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10810/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        buckets = new int[n];

        for (int i = 0; i < m; i++) {
            String[] tmp = br.readLine().split(" ");
            idx1 = Integer.parseInt(tmp[0]);
            idx2 = Integer.parseInt(tmp[1]);
            ballNum = Integer.parseInt(tmp[2]);
            fillBalls(buckets, idx1, idx2, ballNum);
        }

        StringBuilder answer = new StringBuilder();
        for (int bucket : buckets) {
            answer.append(bucket).append(" ");
        }

        System.out.println(answer);


        br.close();
    }
}
