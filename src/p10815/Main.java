package p10815;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int numOfCards = Integer.parseInt(br.readLine());

            Map<Integer, Integer> myDeck = new HashMap<>();
            StringTokenizer cards = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < numOfCards; i++){
                int card = Integer.parseInt(cards.nextToken());
                myDeck.put(card, myDeck.getOrDefault(card, 0)+1);
            }

            List<Integer> checks = new ArrayList<>();
            int numOfChecks = Integer.parseInt(br.readLine());
            cards = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < numOfChecks; i++){
                int check = Integer.parseInt(cards.nextToken());
                checks.add(check);
            }

            CardChecker cc = new CardChecker(myDeck, checks);
            cc.checkCards();
            System.out.println(cc.answer.toString());

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

class CardChecker{

    Map<Integer, Integer> myDeck;
    List<Integer> checks;
    StringBuilder answer = new StringBuilder();

    public CardChecker(Map<Integer, Integer> myDeck, List<Integer> checks){
        this.myDeck = myDeck;
        this.checks = checks;
    }

    public void checkCards(){
        for(int x : checks){
            if(myDeck.containsKey(x)) answer.append(1);
            else answer.append(0);

            answer.append(" ");
        }
    }
}

