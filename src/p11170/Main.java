package p11170;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                int answer = 0;
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for (int x = start; x <= end; x++) {
                    String str = String.valueOf(x);
                    for (String s : str.split("")) {
                        if ("0".equals(s)) {
                            answer++;
                        }
                    }
                }
                System.out.println(answer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
