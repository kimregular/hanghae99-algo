package p11060;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            int[] maze = new int[len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                maze[i] = Integer.parseInt(st.nextToken());
            }


            PathFinder pf = new PathFinder(maze);
            System.out.println(pf.getNumOfJump());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {
    int[] maze;
    boolean[] isVisited;

    public PathFinder(int[] maze) {
        this.maze = maze;
        this.isVisited = new boolean[maze.length];
    }

    public int getNumOfJump() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(maze[0], 0, 0));

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();

                if (currentPoint.idx == maze.length - 1) return currentPoint.numOfJump;

                for (int j = 1; j <= currentPoint.rangeOfJump; j++) {
                    int idx = currentPoint.idx + j;

                    if (idx > maze.length - 1) idx = maze.length - 1;

                    int rangeOfJump = maze[idx];
                    int numOfJump = currentPoint.numOfJump + 1;

                    if (!isVisited[idx]) {
                        isVisited[idx] = true;
                        q.offer(new Point(rangeOfJump, idx, numOfJump));
                    }

                }
            }
        }
        return -1;
    }
}

class Point {
    int rangeOfJump;
    int idx;
    int numOfJump;

    public Point(int rangeOfJump, int idx, int numOfJump) {
        this.rangeOfJump = rangeOfJump;
        this.idx = idx;
        this.numOfJump = numOfJump;
    }
}