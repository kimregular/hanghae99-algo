package p8979;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tokens = br.readLine().split(" ");
            int len = Integer.parseInt(tokens[0]);
            int target = Integer.parseInt(tokens[1]);
            Solution s = new Solution();
            System.out.println(s.solution(getInput(br, len), target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getInput(BufferedReader br, int len) throws IOException {
        int[][] result = new int[len][4];
        for (int i = 0; i < result.length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Integer.parseInt(line[j]);
            }
        }
        return result;
    }
}

class Solution {

    public int solution(int[][] countries, int target) {
        Country[] order = new Country[countries.length];

        for (int i = 0; i < countries.length; i++) {
            int[] country = countries[i];
            int name = country[0];
            int gold = country[1];
            int silver = country[2];
            int bronze = country[3];
            order[i] = new Country(name, gold, silver, bronze);
        }
        Arrays.sort(order);
        order[0].rank = 1;

        rankCountry(order);

        return getOrder(target, order);
    }

    private void rankCountry(Country[] order) {
        for (int i = 1; i < order.length; i++) {
            if (isSameRank(order[i-1], order[i])) {
                order[i].rank = order[i-1].rank;
            } else {
                order[i].rank = i + 1;
            }
        }
    }

    private boolean isSameRank(Country prev, Country cur) {
        return cur.gold == prev.gold && cur.silver == prev.silver && cur.bronze == prev.bronze;
    }

    private int getOrder(int target, Country[] order) {
        for (Country country : order) {
            if (country.name == target) {
                return country.rank;
            }
        }
        return -1;
    }

    private class Country implements Comparable<Country> {

        int name;
        int gold;
        int silver;
        int bronze;
        int rank = 0;

        public Country(int name, int gold, int silver, int bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }


        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold && this.silver == o.silver) {
                return o.bronze - this.bronze;
            } else if (this.gold == o.gold) {
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}

