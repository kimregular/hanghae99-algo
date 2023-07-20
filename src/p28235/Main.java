package p28235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Main ma = new Main();
        System.out.println(ma.solution(str));


        br.close();
    }

    public String solution(String string) {
        switch (string) {
            case "SONGDO":
                return "HIGHSCHOOL";
            case "CODE":
                return "MASTER";
            case "2023":
                return "0611";
            case "ALGORITHM":
                return "CONTEST";
        }

        return "DONE";
    }
}
