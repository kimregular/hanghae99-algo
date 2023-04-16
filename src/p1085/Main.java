package p1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int x;
    static int y;

    static int xMax;
    static int yMax;

    static int[] arr;

    static Integer result = Integer.MAX_VALUE;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        xMax = Integer.parseInt(st.nextToken()) - x;
        yMax = Integer.parseInt(st.nextToken()) - y;

        arr = new int[]{x, y, xMax, yMax};

        for (int i : arr) {
            result = Math.min(result, i);
        }
        System.out.println(result);


        br.close();
    }
}
