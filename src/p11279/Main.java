package p11279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfInputs = Integer.parseInt(br.readLine());

            for (int i = 0; i < numOfInputs; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num == 0) {
                    if (pQ.isEmpty()) System.out.println(0);
                    else System.out.println(pQ.poll());
                } else {
                    pQ.offer(num);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
