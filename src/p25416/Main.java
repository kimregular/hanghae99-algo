package p25416;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[][] board = new int[5][5];

            for (int i = 0; i < 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 5; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer start = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(start.nextToken());
            int y = Integer.parseInt(start.nextToken());
            Point startPoint = new Point(x, y, 0);
            PathFinder pf = new PathFinder(board, startPoint);
            System.out.println(pf.getNumOfSteps());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PathFinder {

    int[][] board;
    Point startPoint;
    boolean[][] isVisited = new boolean[5][5];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};


    public PathFinder(int[][] board, Point startPoint) {
        this.board = board;
        this.startPoint = startPoint;
    }

    public int getNumOfSteps() {
        Queue<Point> q = new LinkedList<>();
        q.offer(startPoint);
        isVisited[startPoint.x][startPoint.y] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point currentPoint = q.poll();

                if(board[currentPoint.x][currentPoint.y] == 1) return currentPoint.numOfSteps;

                for (int j = 0; j < 4; j++) {
                    int nx = currentPoint.x + dx[j];
                    int ny = currentPoint.y + dy[j];

                    if (isWithinBoard(nx, ny) && board[nx][ny] != -1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny, currentPoint.numOfSteps + 1));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isWithinBoard(int x, int y){
        return x >= 0 && x < board.length && y >= 0 && y < board[x].length;
    }
}

class Point {

    int x;
    int y;
    int numOfSteps;

    public Point(int x, int y, int numOfSteps) {
        this.x = x;
        this.y = y;
        this.numOfSteps = numOfSteps;
    }
}