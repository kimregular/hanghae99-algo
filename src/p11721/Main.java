package p11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution(String st) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            sb.append(st.charAt(i));
            if (sb.length() == 10) {
                System.out.println(sb);
                sb.setLength(0);
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Main s = new Main();
        s.solution(st);
        br.close();
    }
}
