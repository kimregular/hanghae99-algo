package p13627;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int R;



    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p13627/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        if (num == R) {
            System.out.println("*");
        } else {
            int[] arr = new int[num + 1];

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = 1;
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) {
                    System.out.print(i + " ");
                }
            }
        }

        br.close();
    }
}
