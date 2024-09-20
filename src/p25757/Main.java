package p25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.getGame(), ip.getPeople()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        String game = tokens[1];

        String[] people = new String[len];
        for (int i = 0; i < people.length; i++) {
            people[i] = br.readLine();
        }
        return new Input(game, people);
    }

    private static class Input {

        private final String game;
        private final String[] people;

        public Input(String game, String[] people) {
            this.game = game;
            this.people = people;
        }

        public String getGame() {
            return game;
        }

        public String[] getPeople() {
            return people;
        }
    }
}


class Solution {

    public int solution(String game, String[] people) {
        return getDistinctPeople(people).size() / getNumOfPlayer(game);
    }

    private Set<String> getDistinctPeople(String[] people) {
        Set<String> distinctPeople = new HashSet<>();
        for (String person : people) {
            distinctPeople.add(person);
        }
        return distinctPeople;
    }

    private int getNumOfPlayer(String game) {
        if(game.equals("Y")) return 1;
        if(game.equals("F")) return 2;
        return 3;
    }
}