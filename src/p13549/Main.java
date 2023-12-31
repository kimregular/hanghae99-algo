package p13549;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int myLocation = Integer.parseInt(st.nextToken());
            int targetLocation = Integer.parseInt(st.nextToken());

            Solution s = new Solution(myLocation, targetLocation);
            System.out.println(s.findSister());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int myLocation;
    int targetLocation;
    boolean[] isVisited;

    public Solution(int myLocation, int targetLocation) {
        this.myLocation = myLocation;
        this.targetLocation = targetLocation;
        this.isVisited = new boolean[200000];
    }

    public int findSister() {
        return BFS();
    }

    private int BFS() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(this.myLocation, 0));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();

                if(currentPoint.location == this.targetLocation) return currentPoint.time;

                for (int j = 0; j < 3; j++) {
                    int position = 0;
                    int time = currentPoint.time;
                    if (j == 0) {
                        position = currentPoint.location * 2;
                    } else if (j == 1) {
                        position = currentPoint.location - 1;
                        time += 1;
                    } else {
                        position = currentPoint.location + 1;
                        time += 1;
                    }

                    if (isPossible(position) && !this.isVisited[position]) {
                        this.isVisited[position] = true;
                        q.offer(new Point(position, time));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isPossible(int x) {
        return x >= 0 && x < this.isVisited.length;
    }
}

class Point {

    int location;
    int time;

    public Point(int location, int time) {
        this.location = location;
        this.time = time;
    }
}