package p9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String st = br.readLine();
            System.out.println(st.charAt(0) + "" + st.charAt(st.length()-1));
        }
        br.close();
    }
}
