package p27324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Main m = new Main();
        System.out.println(m.solution(str));
        br.close();
    }

    public int solution(String str) {
        if (str.charAt(0) == str.charAt(1)) {
            return 1;
        }
        return 0;
    }
}

