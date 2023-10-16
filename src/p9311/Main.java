package p9311;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                String[][] maze = new String[r][c];

                for (int x = 0; x < r; x++) {
                    String[] tokens = br.readLine().split("");
                    maze[x] = Arrays.copyOf(tokens, c);
                }

                PathFinder pf = new PathFinder(maze);
                System.out.println(pf.getShortestPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    String[][] maze;
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public PathFinder(String[][] maze) {
        this.maze = maze;
        this.isVisited = new boolean[maze.length][maze[0].length];
    }

    public String getShortestPath() {
        int shortestPath = 0;

        Point start = findRobot();
        shortestPath = findPath(start);
        if(shortestPath == Integer.MAX_VALUE) return "No Exit";
        return "Shortest Path: " + shortestPath ;
    }

    private int findPath(Point start) {
        int path = Integer.MAX_VALUE;

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        isVisited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();

                if (maze[currentPoint.x][currentPoint.y].equals("G")) {
                    path = Math.min(path, currentPoint.numOfMove);
                }

                for (int j = 0; j < 4; j++) {
                    int nx = currentPoint.x + dx[j];
                    int ny = currentPoint.y + dy[j];

                    if (isWithinMaze(nx, ny) && !"X".equals(maze[nx][ny]) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny, currentPoint.numOfMove + 1));
                    }
                }
            }
        }

        return path;
    }

    private boolean isWithinMaze(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length;
    }

    private Point findRobot() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if ("S".equals(maze[i][j])) {
                    return new Point(i, j, 0);
                }
            }
        }

        return null;
    }
}

class Point {
    int x;
    int y;
    int numOfMove;

    public Point(int x, int y, int numOfMove) {
        this.x = x;
        this.y = y;
        this.numOfMove = numOfMove;
    }
}