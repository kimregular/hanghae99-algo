package p11728;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sizeOfA = Integer.parseInt(st.nextToken());
            int sizeOfB = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < sizeOfA; i++) {
                result.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < sizeOfB; i++) {
                result.add(Integer.parseInt(st.nextToken()));
            }

            result.sort(Comparator.naturalOrder());

            for (Integer ints : result) {
                bw.write(ints + " ");
            }
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
