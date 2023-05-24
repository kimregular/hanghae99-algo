package p19698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int num;
    static int w;
    static int h;
    static int size;

    static void getNum(int num, int w, int h, int size) {
        int tem1 = w/size;
        int tem2 = h/size;

        int tmp = tem1 * tem2;

        System.out.println(Math.min(num, tmp));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());


        getNum(num, w, h, size);

        br.close();
    }
}
