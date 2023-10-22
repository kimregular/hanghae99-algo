package p28074;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        boolean[] flag = new boolean[26];

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] arr = br.readLine().toCharArray();

            for (char x : arr) {
                flag[x - 'A'] = true;
            }

            char[] MOBIS = {'M', 'O', 'B', 'I', 'S'};

            for (char letter : MOBIS) {
                if (!flag[letter - 'A']) {
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
