package p6798;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer startPosition = new StringTokenizer(br.readLine(), " ");
            StringTokenizer target = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(startPosition.nextToken()) - 1;
            int startY = Integer.parseInt(startPosition.nextToken()) - 1;

            int targetX = Integer.parseInt(target.nextToken()) - 1;
            int targetY = Integer.parseInt(target.nextToken()) - 1;

            PathFinder pf = new PathFinder(new Point(startX, startY, 0), new Point(targetX, targetY, 0));
            System.out.println(pf.findPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    Point startPoint;
    Point target;

    int[][] board = new int[8][8];
    boolean[][] isVisited = new boolean[8][8];

    int[] dx = {1, -1, 2, 2, 1, -1, -2, -2};
    int[] dy = {2, 2, 1, -1, -2, -2, 1, -1};

    public PathFinder(Point startPoint, Point target) {
        this.startPoint = startPoint;
        this.target = target;
    }

    public int findPath() {
        Queue<Point> q = new LinkedList<>();
        q.offer(startPoint);
        isVisited[startPoint.x][startPoint.y] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();

                if (currentPoint.x == target.x && currentPoint.y == target.y) return currentPoint.numOfMove;

                for (int j = 0; j < 8; j++) {
                    int nx = currentPoint.x + dx[j];
                    int ny = currentPoint.y + dy[j];

                    if (isWithinBoard(nx, ny) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny, currentPoint.numOfMove + 1));
                    }
                }
            }
        }

        return 0;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
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
