package p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int numOfCard = Integer.parseInt(br.readLine());
            int[] cardList = new int[numOfCard];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < numOfCard; i++) {
                cardList[i] = Integer.parseInt(st.nextToken());
            }

            int numOfTarget = Integer.parseInt(br.readLine());
            int[] target = new int[numOfTarget];
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < numOfTarget; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution(cardList, target);
            System.out.println(s.solution());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    Map<Integer, Integer> myCard;
    int[] targetList;

    public Solution(int[] cardList, int[] targetList) {
        this.myCard = new HashMap<>();
        for (int i : cardList) {
            myCard.put(i, myCard.getOrDefault(i, 0) + 1);
        }
        this.targetList = targetList;
    }

    public String solution() {
        StringBuilder answer = new StringBuilder();

        for (int i : targetList) {
            if (myCard.containsKey(i)) {
                answer.append(myCard.get(i));
            } else {
                answer.append(0);
            }
            answer.append(" ");
        }

        return answer.toString();
    }
}
