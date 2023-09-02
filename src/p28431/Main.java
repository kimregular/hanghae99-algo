package p28431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = 5;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < TEST_CASE; i++) {
                int tmp = Integer.parseInt(br.readLine());

                if (map.containsKey(tmp)) {
                    map.remove(tmp);
                } else {
                    map.put(tmp, 1);
                }
            }

            for (Integer i : map.keySet()) {
                System.out.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
