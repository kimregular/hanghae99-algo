package p10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Set<Integer> set = new TreeSet<>();

            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            for (Integer i : set) {
                System.out.print(i + " ");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
