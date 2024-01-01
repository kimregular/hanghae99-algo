package p11723;

import java.io.*;
import java.util.*;

public class Main {
    public static Set<String> group = new HashSet<>();
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfOrders = Integer.parseInt(br.readLine());


            for (int i = 0; i < numOfOrders; i++) {
                String[] order = br.readLine().split(" ");
                order(order);
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void order(String[] order) {
        if (order[0].equals("add")) {
            if (!group.contains(order[1])) {
                group.add((order[1]));
            }
        } else if (order[0].equals("remove")) {
            group.remove(order[1]);
        } else if (order[0].equals("check")) {
            if (group.contains(order[1])) {
                answer.append("1");
            } else {
                answer.append("0");
            }
            answer.append("\n");
        } else if (order[0].equals("toggle")) {
            if (group.contains(order[1])) {
                group.remove(order[1]);
            } else {
                group.add(order[1]);
            }
        } else if (order[0].equals("all")) {
            group.clear();
            for (int i = 1; i < 21; i++) {
                group.add(String.valueOf(i));
            }
        } else {
            group.clear();
        }
    }
}
