package p10809;

import java.io.*;
import java.util.Arrays;

public class Main {

    // a = 97
    // z = 123

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        char[] st = br.readLine().toCharArray();
        int idx = 0;
        for (int i = 0; i < st.length; i++) {
            if (arr[st[i] - 97] == -1) {
                arr[st[i] - 97] = idx;
            }
            idx++;
        }

        for (int i : arr) {
            bw.write(i + " ");
        }


        bw.flush();
        br.close();
    }
}
