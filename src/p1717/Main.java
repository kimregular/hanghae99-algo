package p1717;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfPeople = Integer.parseInt(st.nextToken());
            int numOfRelation = Integer.parseInt(st.nextToken());

            RelationNetwork rn = new RelationNetwork(numOfPeople);

            for (int i = 0; i < numOfRelation; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int order = Integer.parseInt(st.nextToken());
                int personA = Integer.parseInt(st.nextToken());
                int personB = Integer.parseInt(st.nextToken());

                if (order == 0) {
                    rn.makeFriends(personA, personB);
                } else {
                    boolean haveRelation = rn.areFriends(personA, personB);
                    if (haveRelation) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class RelationNetwork {

    private int[] relation;

    public RelationNetwork(int numOfPeople) {
        this.relation = new int[numOfPeople + 1];
        for (int i = 0; i < this.relation.length; i++) {
            this.relation[i] = i;
        }
    }

    public boolean areFriends(int personA, int personB) {
        return findRootRelation(personA) == findRootRelation(personB);
    }

    public void makeFriends(int personA, int personB) {
        int rootA = findRootRelation(personA);
        int rootB = findRootRelation(personB);

        if (rootA != rootB) {
            this.relation[rootA] = rootB;
        }
    }

    public int findRootRelation(int person) {
        if (person != this.relation[person]) {
            this.relation[person] = findRootRelation(this.relation[person]);
        }
        return this.relation[person];
    }
}