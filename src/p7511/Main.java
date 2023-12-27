package p7511;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {

                int numOfPeople = Integer.parseInt(br.readLine());
                Solution s = new Solution(numOfPeople);

                int numOfRelation = Integer.parseInt(br.readLine());
                for (int i = 0; i < numOfRelation; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                    int personA = Integer.parseInt(st.nextToken());
                    int personB = Integer.parseInt(st.nextToken());
                    s.connectUnion(personA, personB);
                }

                int relationCase = Integer.parseInt(br.readLine());

                result.append("Scenario ").append(CASE + 1).append(":").append("\n");
                for (int i = 0; i < relationCase; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                    int personA = Integer.parseInt(st.nextToken());
                    int personB = Integer.parseInt(st.nextToken());

                    if (s.isConnected(personA, personB)) {
                        result.append("1");
                    } else {
                        result.append("0");
                    }
                    result.append("\n");
                }
                result.append("\n");
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] connection;

    public Solution(int numOfPeople) {
        this.connection = new int[numOfPeople];
        for (int i = 0; i < this.connection.length; i++) {
            this.connection[i] = i;
        }
    }

    public boolean isConnected(int personA, int personB) {
        return findConnection(personA) == findConnection(personB);
    }

    public int findConnection(int person) {
        if (person != this.connection[person]) {
            return this.connection[person] = findConnection(this.connection[person]);
        }
        return this.connection[person];
    }

    public void connectUnion(int personA, int personB) {
        int pA = findConnection(personA);
        int pB = findConnection(personB);
        if(pA != pB) this.connection[Math.max(pA, pB)] = Math.min(pA, pB);
    }
}