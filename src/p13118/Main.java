package p13118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int[] arr;

    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        arr = new int[4];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine().split(" ")[0]);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println(i+1);
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(0);
        }

        br.close();
    }
}
