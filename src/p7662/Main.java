package p7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());

            while (TEST_CASE-- > 0) {
                Solution s = new Solution();
                int orderLen = Integer.parseInt(br.readLine());
                while (orderLen-- > 0) {
                    String[] order = br.readLine().split(" ");
                    s.process(order[0], Integer.parseInt(order[1]));
                }
                System.out.println(s.getResult());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    DoublePriorityQueue dpq = new DoublePriorityQueue();

    public void process(String order, int num) {
        dpq.calc(order, num);
    }

    public String getResult() {
        return dpq.getResult();
    }
}

class DoublePriorityQueue {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public String getResult() {
        if (map.isEmpty()) return "EMPTY";
        return map.lastKey() + " " + map.firstKey();
    }

    public void calc(String order, int num) {
        if (order.equals("I")) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } else {
            deleteCalc(num);
        }
    }

    private void deleteCalc(int num) {
        if (map.isEmpty()) return;

        int key = (num == 1) ? map.lastKey() : map.firstKey();

        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}
