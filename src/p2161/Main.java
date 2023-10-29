package p2161;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> deck = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int numOfCards = Integer.parseInt(br.readLine());

            for (int i = 1; i < numOfCards + 1; i++) {
                deck.add(i);
            }

            while (deck.size() != 1) {
                System.out.print(deck.poll() + " ");

                deck.add(deck.poll());
            }

            System.out.print(deck.poll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
