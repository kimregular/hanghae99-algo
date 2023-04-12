package p1267;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int num;

    static int[] arr;

    static final int Y_SECOND = 30;
    static final int Y_COST = 10;
    static final int M_SECOND = 60;
    static final int M_COST = 15;

    static int yPrice;
    static int mPrice;


    public static int getPrice(int[] arr, int second, int cost) {
        int total = 0;
        int tmp = 0;
        for (int i : arr) {
            tmp = i / second;
            total += tmp * cost;
            tmp = i % second;
            total += cost;
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1267/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }


        yPrice =  getPrice(arr, Y_SECOND, Y_COST);
        mPrice =  getPrice(arr, M_SECOND, M_COST);

        if (yPrice == mPrice) {
            System.out.println("Y M " + yPrice);
        } else if (yPrice < mPrice) {
            System.out.println("Y " + yPrice);
        } else {
            System.out.println("M " + mPrice);
        }


        br.close();
    }
}
