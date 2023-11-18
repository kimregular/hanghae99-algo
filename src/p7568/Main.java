package p7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int numOfPeople = Integer.parseInt(br.readLine());
            int[][] people = new int[numOfPeople][2];

            for (int person = 0; person < numOfPeople; person++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                people[person][0] = weight;
                people[person][1] = height;
            }
            BiggerFinder bf = new BiggerFinder(people);
            System.out.println(bf.getBigger());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class BiggerFinder {

    int[][] people;
    int[] ranks;

    public BiggerFinder(int[][] people) {
        this.people = people;
        this.ranks = new int[people.length];
    }

    public String getBigger() {
        StringBuilder result = new StringBuilder();

        findBigger();

        for (int rank : ranks) {
            result.append(rank).append(" ");
        }
        return result.toString();
    }

    private void findBigger() {
        for (int i = 0; i < people.length; i++) {
            int rank = 1;
            int[] currentPerson = this.people[i];

            for (int j = 0; j < people.length; j++) {
                int[] comparePerson = this.people[j];

                if (i != j) {
                    if (currentPerson[0] < comparePerson[0] && currentPerson[1] < comparePerson[1]) {
                        rank++;
                    }
                }
            }
            ranks[i] = rank;
        }
    }
}
