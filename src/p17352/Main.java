package p17352;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfIslands = Integer.parseInt(br.readLine());

            Solution s = new Solution(numOfIslands);

            StringTokenizer st;

            for (int i = 0; i < numOfIslands - 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int islandA = Integer.parseInt(st.nextToken());
                int islandB = Integer.parseInt(st.nextToken());

                s.connectUnion(islandA, islandB);
            }

            System.out.println(s.getUnconnectedIsland());


        } catch (IOException E) {
            throw new RuntimeException(E);
        }
    }
}

class Solution {

    int[] connection;

    public Solution(int numOfIslands) {
        this.connection = new int[numOfIslands + 1];
        for (int i = 0; i < this.connection.length; i++) {
            this.connection[i] = i;
        }
    }

    public String getUnconnectedIsland() {
        for (int i = 1; i < this.connection.length; i++) {
            if (!isConnected(i, i + 1)) {
                return i + " " + (i + 1);
            }
        }
        return "-1";
    }

    public boolean isConnected(int islandA, int islandB) {
        return findConnection(islandA) == findConnection(islandB);
    }

    public int findConnection(int island) {
        if (island != this.connection[island]) {
            return this.connection[island] = findConnection(this.connection[island]);
        } else {
            return this.connection[island];
        }
    }

    public void connectUnion(int islandA, int islandB) {
        int iA = findConnection(islandA);
        int iB = findConnection(islandB);
        if (iA != iB) {
            this.connection[Math.max(iA, iB)] = Math.min(iA, iB);
        }

    }
}