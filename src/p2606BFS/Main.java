package p2606BFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfComputers = Integer.parseInt(br.readLine());

            int[][] network = new int[numOfComputers + 1][numOfComputers + 1];

            int numOfNodes = Integer.parseInt(br.readLine());

            for (int i = 0; i < numOfNodes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                network[x][y] = 1;
                network[y][x] = 1;
            }

            Virus v = new Virus(network);
            System.out.println(v.getNumOfInfectedComputers(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Virus {

    int[][] network;
    boolean[] isInfected;


    public Virus(int[][] network) {
        this.network = network;
        this.isInfected = new boolean[network.length];
    }

    public int getNumOfInfectedComputers(int num) {
        int numOfInfectedComputers = 0;
        Queue<Integer> q = new LinkedList<>();
        isInfected[num] = true;
        q.offer(num);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int infectedComputer = q.poll();

                for (int targetComputer = 1; targetComputer < network[infectedComputer].length; targetComputer++) {

                    if (network[infectedComputer][targetComputer] == 1 && (!isInfected[targetComputer])) {
                            isInfected[targetComputer] = true;
                            numOfInfectedComputers++;
                            q.offer(targetComputer);

                    }
                }
            }
        }
        return numOfInfectedComputers;
    }
}