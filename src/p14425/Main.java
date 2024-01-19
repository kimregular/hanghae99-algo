package p14425;

import java.io.*;
import java.util.*;

public class Main {

    public static Set<String> dict = new HashSet<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                dict.add(br.readLine());
            }

            int answer = 0;
            for (int i = 0; i < m; i++) {
                if (dict.contains(br.readLine())) {
                    answer++;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
