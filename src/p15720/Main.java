package p15720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.burgers, ip.sides, ip.drinks));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfBurgers = Integer.parseInt(tokens[0]);
        int numOfSides = Integer.parseInt(tokens[1]);
        int numOfDrinks = Integer.parseInt(tokens[2]);

        List<Integer> burgers = new ArrayList<>();
        List<Integer> sides = new ArrayList<>();
        List<Integer> drinks = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfBurgers; i++) {
            burgers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfSides; i++) {
            sides.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfDrinks; i++) {
            drinks.add(Integer.parseInt(st.nextToken()));
        }

        return new Input(burgers, sides, drinks);
    }

    private static class Input {
        private final List<Integer> burgers;
        private final List<Integer> sides;
        private final List<Integer> drinks;

        public Input(List<Integer> burgers, List<Integer> sides, List<Integer> drinks) {
            this.burgers = burgers;
            this.sides = sides;
            this.drinks = drinks;
        }
    }
}

class Solution {

    public String solution(List<Integer> burgers, List<Integer> sides, List<Integer> drinks) {
        StringBuilder answer = new StringBuilder();

        answer.append(getTotal(burgers, sides, drinks)).append("\n");

        burgers.sort(Collections.reverseOrder());
        sides.sort(Collections.reverseOrder());
        drinks.sort(Comparator.reverseOrder());

        int discount = 0;
        int maxLen = Math.max(burgers.size(), Math.max(sides.size(), drinks.size()));

        for (int i = 0; i < maxLen; i++) {
            int burgerPrice = 0;
            int sidePrice = 0;
            int drinkPrice = 0;

            if(i < burgers.size()) burgerPrice = burgers.get(i);
            if(i < sides.size()) sidePrice = sides.get(i);
            if(i < drinks.size()) drinkPrice = drinks.get(i);

            int sum = burgerPrice + sidePrice + drinkPrice;
            if(burgerPrice != 0 && sidePrice != 0 && drinkPrice != 0) discount += (int) (sum * 0.9);
            else discount += sum;
        }

        answer.append(discount);
        return answer.toString();
    }

    private int getTotal(List<Integer> burgers, List<Integer> sides, List<Integer> drinks) {
        int result = 0;

        for (int burger : burgers) {
            result += burger;
        }

        for (int side : sides) {
            result += side;
        }

        for (int drink : drinks) {
            result += drink;
        }

        return result;
    }
}