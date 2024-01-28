package p5568;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfCards = Integer.parseInt(br.readLine());
            int limit = Integer.parseInt(br.readLine());

            int[] cards = new int[numOfCards];
            for (int i = 0; i < numOfCards; i++) {
                cards[i] = Integer.parseInt(br.readLine());
            }

            Solution s = new Solution(limit, cards);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int limit;
    int[] cards;
    Set<String> probability = new HashSet<>();
    boolean[] isChecked;

    public Solution(int limit, int[] cards) {
        this.limit = limit;
        this.cards = cards;
        this.isChecked = new boolean[cards.length];
    }

    public int solution() {
        putCards(0, "");
        return this.probability.size();
    }

    public void putCards(int cnt, String str) {
        if (cnt == this.limit) {
            this.probability.add(str);
            return;
        }
        for (int i = 0; i < this.cards.length; i++) {
            if(this.isChecked[i]) continue;
            this.isChecked[i] = true;
            putCards(cnt + 1, str + this.cards[i]);
            this.isChecked[i] = false;
        }
    }
}