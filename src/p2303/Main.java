package p2303;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br) throws IOException {
        int numOfPeople = Integer.parseInt(br.readLine());

        int[][] cards = new int[numOfPeople][5];

        for (int i = 0; i < cards.length; i++) {
            StringTokenizer playerCards = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < cards[i].length; j++) {
                cards[i][j] = Integer.parseInt(playerCards.nextToken());
            }
        }

        return cards;
    }
}

class Solution {

    public int solution(int[][] cards) {
        Player[] players = getReadyPlayers(cards);

        return getWinner(players);
    }

    private int getWinner(Player[] players) {
        int winner = 0;
        int maxScore = 0;
        for (Player p : players) {
            int score = p.getMaxUnit();
            if (score > maxScore) {
                maxScore = score;
                winner = p.getNum();
            } else if (score == maxScore) {
                winner = Math.max(winner, p.getNum());
            }
        }
        return winner;
    }

    private Player[] getReadyPlayers(int[][] cards) {
        Player[] players = new Player[cards.length];
        for (int i = 0; i < cards.length; i++) {
            players[i] = new Player(i + 1, cards[i]);
        }
        return players;
    }

    class Player {

        int num;
        int[] cards;

        public Player(int num, int[] cards) {
            this.num = num;
            this.cards = cards;
        }

        public int getNum() {
            return this.num;
        }

        public int getMaxUnit() {
            int maxUnit = 0;

            for (int i = 0; i < this.cards.length; i++) {
                for (int j = i + 1; j < this.cards.length; j++) {
                    for (int k = j + 1; k < this.cards.length; k++) {
                        int tmp = this.cards[i] + this.cards[j] + this.cards[k];
                        tmp %= 10;

                        if(tmp > maxUnit) maxUnit = tmp;
                    }
                }
            }
            return maxUnit;
        }
    }

}

