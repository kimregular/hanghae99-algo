package p1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrOfPoketmon = new ArrayList<>();
        Map<String, Integer> mapOfPoketmon = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfPoketmon = Integer.parseInt(st.nextToken());
            int numOfOrder = Integer.parseInt(st.nextToken());

            for (int i = 0; i < numOfPoketmon; i++) {
                String poketmon = br.readLine();
                arrOfPoketmon.add(poketmon);
                mapOfPoketmon.put(poketmon, i);
            }

            for (int i = 0; i < numOfOrder; i++) {
                int tmp = 0;
                String order = br.readLine();
                try {
                    tmp = Integer.parseInt(order);
                    System.out.println(arrOfPoketmon.get(tmp - 1));
                } catch (NumberFormatException e) {
                    System.out.println(mapOfPoketmon.get(order) + 1);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
