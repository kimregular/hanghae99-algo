package p10871;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int len;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            if (num > tmp) {
                bw.write(tmp + " ");
            }
        }


        bw.flush();
        br.close();
    }
}
